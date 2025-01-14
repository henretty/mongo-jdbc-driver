package com.mongodb.jdbc.integration.testharness;

import java.lang.reflect.Field;
import java.sql.DatabaseMetaData;
import java.sql.Types;

public class TestTypeInfo {
    private static final String COLUMN_NO_NULLS = "columnNoNulls";
    private static final String COLUMN_NULLABLE = "columnNullable";
    private static final String COLUMN_NULLABLE_UNKNOWN = "columnNullableUnknown";

    public static int typesStringToInt(String type) throws IllegalAccessException {
        for (Field field : Types.class.getFields()) {
            if (field.getName().equalsIgnoreCase(type)) {
                return (field.getInt(new Object()));
            }
        }
        throw new IllegalArgumentException("unknown type: " + type);
    }

    public static String typesIntToString(int type) throws IllegalAccessException {
        for (Field field : Types.class.getFields()) {
            if (type == field.getInt(new Object())) {
                return (field.getName());
            }
        }
        throw new IllegalArgumentException("unknown type: " + type);
    }

    public static int nullableStringToInt(String type) {
        if (type.toUpperCase().equals(COLUMN_NO_NULLS.toUpperCase())) {
            return DatabaseMetaData.columnNoNulls;
        } else if (type.toUpperCase().equals(COLUMN_NULLABLE.toUpperCase())) {
            return DatabaseMetaData.columnNullable;
        } else if (type.toUpperCase().equals(COLUMN_NULLABLE_UNKNOWN.toUpperCase())) {
            return DatabaseMetaData.columnNullableUnknown;
        }
        throw new IllegalArgumentException("unknown nullable type: " + type);
    }

    public static String nullableIntToString(int type) {
        switch (type) {
            case DatabaseMetaData.columnNoNulls:
                return COLUMN_NO_NULLS;
            case DatabaseMetaData.columnNullable:
                return COLUMN_NULLABLE;
            case DatabaseMetaData.columnNullableUnknown:
                return COLUMN_NULLABLE_UNKNOWN;
        }
        throw new IllegalArgumentException("unknown nullable type: " + type);
    }
}
