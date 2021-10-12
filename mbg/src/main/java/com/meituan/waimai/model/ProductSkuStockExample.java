package com.meituan.waimai.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSkuStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductSkuStockExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNull() {
            addCriterion("attr_id is null");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNotNull() {
            addCriterion("attr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttrIdEqualTo(Integer value) {
            addCriterion("attr_id =", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotEqualTo(Integer value) {
            addCriterion("attr_id <>", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThan(Integer value) {
            addCriterion("attr_id >", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attr_id >=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThan(Integer value) {
            addCriterion("attr_id <", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThanOrEqualTo(Integer value) {
            addCriterion("attr_id <=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdIn(List<Integer> values) {
            addCriterion("attr_id in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotIn(List<Integer> values) {
            addCriterion("attr_id not in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdBetween(Integer value1, Integer value2) {
            addCriterion("attr_id between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attr_id not between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andActivityStockIsNull() {
            addCriterion("activity_stock is null");
            return (Criteria) this;
        }

        public Criteria andActivityStockIsNotNull() {
            addCriterion("activity_stock is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStockEqualTo(String value) {
            addCriterion("activity_stock =", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockNotEqualTo(String value) {
            addCriterion("activity_stock <>", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockGreaterThan(String value) {
            addCriterion("activity_stock >", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockGreaterThanOrEqualTo(String value) {
            addCriterion("activity_stock >=", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockLessThan(String value) {
            addCriterion("activity_stock <", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockLessThanOrEqualTo(String value) {
            addCriterion("activity_stock <=", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockLike(String value) {
            addCriterion("activity_stock like", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockNotLike(String value) {
            addCriterion("activity_stock not like", value, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockIn(List<String> values) {
            addCriterion("activity_stock in", values, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockNotIn(List<String> values) {
            addCriterion("activity_stock not in", values, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockBetween(String value1, String value2) {
            addCriterion("activity_stock between", value1, value2, "activityStock");
            return (Criteria) this;
        }

        public Criteria andActivityStockNotBetween(String value1, String value2) {
            addCriterion("activity_stock not between", value1, value2, "activityStock");
            return (Criteria) this;
        }

        public Criteria andRealStockIsNull() {
            addCriterion("real_stock is null");
            return (Criteria) this;
        }

        public Criteria andRealStockIsNotNull() {
            addCriterion("real_stock is not null");
            return (Criteria) this;
        }

        public Criteria andRealStockEqualTo(String value) {
            addCriterion("real_stock =", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockNotEqualTo(String value) {
            addCriterion("real_stock <>", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockGreaterThan(String value) {
            addCriterion("real_stock >", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockGreaterThanOrEqualTo(String value) {
            addCriterion("real_stock >=", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockLessThan(String value) {
            addCriterion("real_stock <", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockLessThanOrEqualTo(String value) {
            addCriterion("real_stock <=", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockLike(String value) {
            addCriterion("real_stock like", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockNotLike(String value) {
            addCriterion("real_stock not like", value, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockIn(List<String> values) {
            addCriterion("real_stock in", values, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockNotIn(List<String> values) {
            addCriterion("real_stock not in", values, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockBetween(String value1, String value2) {
            addCriterion("real_stock between", value1, value2, "realStock");
            return (Criteria) this;
        }

        public Criteria andRealStockNotBetween(String value1, String value2) {
            addCriterion("real_stock not between", value1, value2, "realStock");
            return (Criteria) this;
        }

        public Criteria andSoldStatusIsNull() {
            addCriterion("sold_status is null");
            return (Criteria) this;
        }

        public Criteria andSoldStatusIsNotNull() {
            addCriterion("sold_status is not null");
            return (Criteria) this;
        }

        public Criteria andSoldStatusEqualTo(String value) {
            addCriterion("sold_status =", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusNotEqualTo(String value) {
            addCriterion("sold_status <>", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusGreaterThan(String value) {
            addCriterion("sold_status >", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sold_status >=", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusLessThan(String value) {
            addCriterion("sold_status <", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusLessThanOrEqualTo(String value) {
            addCriterion("sold_status <=", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusLike(String value) {
            addCriterion("sold_status like", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusNotLike(String value) {
            addCriterion("sold_status not like", value, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusIn(List<String> values) {
            addCriterion("sold_status in", values, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusNotIn(List<String> values) {
            addCriterion("sold_status not in", values, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusBetween(String value1, String value2) {
            addCriterion("sold_status between", value1, value2, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSoldStatusNotBetween(String value1, String value2) {
            addCriterion("sold_status not between", value1, value2, "soldStatus");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNull() {
            addCriterion("origin_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNotNull() {
            addCriterion("origin_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceEqualTo(BigDecimal value) {
            addCriterion("origin_price =", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotEqualTo(BigDecimal value) {
            addCriterion("origin_price <>", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThan(BigDecimal value) {
            addCriterion("origin_price >", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("origin_price >=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThan(BigDecimal value) {
            addCriterion("origin_price <", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("origin_price <=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIn(List<BigDecimal> values) {
            addCriterion("origin_price in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotIn(List<BigDecimal> values) {
            addCriterion("origin_price not in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("origin_price between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("origin_price not between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNull() {
            addCriterion("current_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNotNull() {
            addCriterion("current_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceEqualTo(BigDecimal value) {
            addCriterion("current_price =", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotEqualTo(BigDecimal value) {
            addCriterion("current_price <>", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThan(BigDecimal value) {
            addCriterion("current_price >", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price >=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThan(BigDecimal value) {
            addCriterion("current_price <", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price <=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIn(List<BigDecimal> values) {
            addCriterion("current_price in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotIn(List<BigDecimal> values) {
            addCriterion("current_price not in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price not between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andBoxFeeIsNull() {
            addCriterion("box_fee is null");
            return (Criteria) this;
        }

        public Criteria andBoxFeeIsNotNull() {
            addCriterion("box_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBoxFeeEqualTo(BigDecimal value) {
            addCriterion("box_fee =", value, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeNotEqualTo(BigDecimal value) {
            addCriterion("box_fee <>", value, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeGreaterThan(BigDecimal value) {
            addCriterion("box_fee >", value, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("box_fee >=", value, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeLessThan(BigDecimal value) {
            addCriterion("box_fee <", value, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("box_fee <=", value, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeIn(List<BigDecimal> values) {
            addCriterion("box_fee in", values, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeNotIn(List<BigDecimal> values) {
            addCriterion("box_fee not in", values, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("box_fee between", value1, value2, "boxFee");
            return (Criteria) this;
        }

        public Criteria andBoxFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("box_fee not between", value1, value2, "boxFee");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}