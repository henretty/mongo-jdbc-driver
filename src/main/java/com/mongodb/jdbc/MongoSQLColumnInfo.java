package com.mongodb.jdbc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.bson.BsonType;

public class MongoSQLColumnInfo implements MongoColumnInfo {
    private final String datasource;
    private final String field;
    private final BsonTypeInfo bsonTypeInfo;
    private final boolean isPolymorphic;
    private final int nullable;

    MongoSQLColumnInfo(
            String datasource, String field, BsonTypeInfo bsonTypeInfo, int nullability) {
        this.datasource = datasource;
        this.field = field;
        this.bsonTypeInfo = bsonTypeInfo;
        this.nullable = nullability;
        this.isPolymorphic = bsonTypeInfo == BsonTypeInfo.BSON_BSON;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean isPolymorphic() {
        return isPolymorphic;
    }

    @Override
    public BsonType getBsonTypeEnum() {
        return bsonTypeInfo.getBsonType();
    }

    @Override
    public String getBsonTypeName() {
        return bsonTypeInfo.getBsonName();
    }

    @Override
    public int getJDBCType() {
        return bsonTypeInfo.getJdbcType();
    }

    @Override
    public int getNullability() {
        return nullable;
    }

    @Override
    public String getColumnName() {
        return field;
    }

    @Override
    public String getColumnAlias() {
        return field;
    }

    @Override
    public String getTableName() {
        return datasource;
    }

    @Override
    public String getTableAlias() {
        return datasource;
    }

    @Override
    public String getDatabase() {
        return "";
    }
}
