package com.mongodb.jdbc.integration.testharness.models;

import java.util.List;
import java.util.Map;

public class TestDataEntry {
    public String db;
    public String collection;
    public List<Map<String, Object>> docs;
    public List<Map<String, Object>> docsExtJson;
    public Map<String, Object> schema;
    public List<Map<String, Object>> nonuniqueIndexes;
}
