package com.maple.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;

/**
 * 自定义导出Excel数据注解
 *
 * @author maple
 * @create 2021-07-21 21:54
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel {

    /**
     * 导出时在excel中排序
     */
    int sort() default Integer.MAX_VALUE;

    /**
     * 导出到Excel中的名字
     */
    String name() default "";

    /**
     * 日期格式, 如: yyyy-MM-dd
     */
    String dateFormat() default "";

    /**
     * 如果是字典类型，请设置字典的type值 (如: sys_user_sex)
     */
    String dictType() default "";

    /**
     * 读取内容转表达式 (如: 0=男,1=女,2=未知)
     */
    String readConverterExp() default "";

    /**
     * 分隔符，读取字符串组内容
     */
    String separator() default ",";

    /**
     * BigDecimal 精度 默认:-1(默认不开启BigDecimal格式化)
     */
    int scale() default -1;

    /**
     * BigDecimal 舍入规则 默认:BigDecimal.ROUND_HALF_EVEN
     */
    int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    /**
     * 导出时在excel中每个列的高度 单位为字符
     */
    double height() default 14;

    /**
     * 导出时在excel中每个列的宽 单位为字符
     */
    double width() default 16;

    /**
     * 文字后缀,如% 90 变成90%
     */
    String suffix() default "";

    /**
     * 当值为空时,字段的默认值
     */
    String defaultValue() default "";

    /**
     * 提示信息
     */
    String prompt() default "";

    /**
     * 设置只能选择不能输入的列内容.
     */
    String[] combo() default {};

    /**
     * 是否导出数据,应对需求:有时我们需要导出一份模板,这是标题需要但内容需要用户手工填写.
     */
    boolean isExport() default true;

    /**
     * 另一个类中的属性名称,支持多级获取,以小数点隔开
     */
    String targetAttr() default "";

    /**
     * 是否自动统计数据,在最后追加一行统计数据总和
     */
    boolean isStatistics() default false;

    /**
     * 导出字段对齐方式（0：默认；1：靠左；2：居中；3：靠右）
     */
    Align align() default Align.AUTO;

    /**
     * 字段类型（0：导出导入；1：仅导出；2：仅导入）
     */
    Type type() default Type.ALL;

    /**
     * 导出类型（0数字 1字符串）
     */
    ColumnType cellType() default ColumnType.STRING;

    enum Align {
        /**
         * 默认
         */
        AUTO(0),
        /**
         * 靠左
         */
        LEFT(1),
        /**
         * 居中
         */
        CENTER(2),
        /**
         * 靠右
         */
        RIGHT(3);

        private final int value;

        Align(int value) {
            this.value = value;
        }

        int value() {
            return this.value;
        }
    }

    enum Type
    {
        /**
         * 导出导入
         */
        ALL(0),
        /**
         * 仅导出
         */
        EXPORT(1),
        /**
         * 仅导入
         */
        IMPORT(2);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        int value() {
            return this.value;
        }
    }

    enum ColumnType {
        /**
         * 数字
         */
        NUMERIC(0),
        /**
         * 字符串
         */
        STRING(1),
        /**
         * 图片
         */
        IMAGE(2);

        private final int value;

        ColumnType(int value) {
            this.value = value;
        }

        int value() {
            return this.value;
        }
    }
    
}
