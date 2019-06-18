package com.rats.framework.common.data.sql;


import com.rats.framework.common.data.DataMap;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.ArrayList;
/**
 * MyBatis执行sql工具
 *
 * @author liuzh
 * @since 2015-03-10
 */
public class SqlMappedStatementHandler {

    private Configuration configuration;
    private LanguageDriver languageDriver;

    public SqlMappedStatementHandler(Configuration configuration) {
        this.configuration = configuration;
        languageDriver = configuration.getDefaultScriptingLanuageInstance();
    }

    /**
     * 创建MSID
     *
     * @param sql 执行的sql
     * @param sql 执行的sqlCommandType
     * @return
     */
    public String newMsId(String sql, SqlCommandType sqlCommandType) {
        StringBuilder msIdBuilder = new StringBuilder(sqlCommandType.toString());
        msIdBuilder.append(".").append(sql.hashCode());
        return msIdBuilder.toString();
    }

    /**
     * 是否已经存在该ID
     *
     * @param msId
     * @return
     */
    public boolean hasMappedStatement(String msId) {
        return configuration.hasStatement(msId, false);
    }

    /**
     * 创建一个查询的MS
     *
     * @param msId
     * @param sqlSource  执行的sqlSource
     * @param resultType 返回的结果类型
     */
    public MappedStatement newSelectMappedStatement(String msId, SqlSource sqlSource, final Class<?> resultType) {
        MappedStatement ms = new MappedStatement.Builder(configuration, msId, sqlSource, SqlCommandType.SELECT)
                .resultMaps(new ArrayList<ResultMap>() {
                    {
                        add(new ResultMap.Builder(configuration, "defaultResultMap", resultType, new ArrayList<ResultMapping>(0)).build());
                    }
                })
                .build();

        //缓存
        configuration.addMappedStatement(ms);
        return ms;
    }

    /**
     * 创建一个简单的MS
     *
     * @param msId
     * @param sqlSource      执行的sqlSource
     * @param sqlCommandType 执行的sqlCommandType
     */
    public void newUpdateMappedStatement(String msId, SqlSource sqlSource, SqlCommandType sqlCommandType) {
        MappedStatement ms = new MappedStatement.Builder(configuration, msId, sqlSource, sqlCommandType)
                .resultMaps(new ArrayList<ResultMap>() {
                    {
                        add(new ResultMap.Builder(configuration, "defaultResultMap", int.class, new ArrayList<ResultMapping>(0)).build());
                    }
                })
                .build();
        //缓存
        configuration.addMappedStatement(ms);
    }

    public String selectList(String sql) {
        String msId = newMsId(sql, SqlCommandType.SELECT);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
        newSelectMappedStatement(msId, sqlSource, DataMap.class);
        return msId;
    }

    public String selectList(String sql, Class<?> parameterType) {
        String msId = newMsId(sql + parameterType, SqlCommandType.SELECT);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
        newSelectMappedStatement(msId, sqlSource, DataMap.class);
        return msId;
    }

    public String insert(String sql) {
        String msId = newMsId(sql, SqlCommandType.INSERT);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
        newUpdateMappedStatement(msId, sqlSource, SqlCommandType.INSERT);
        return msId;
    }

    public String insert(String sql, Class<?> parameterType) {
        String msId = newMsId(sql + parameterType, SqlCommandType.INSERT);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
        newUpdateMappedStatement(msId, sqlSource, SqlCommandType.INSERT);
        return msId;
    }

    public String update(String sql) {
        String msId = newMsId(sql, SqlCommandType.UPDATE);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
        newUpdateMappedStatement(msId, sqlSource, SqlCommandType.UPDATE);
        return msId;
    }

    public String update(String sql, Class<?> parameterType) {
        String msId = newMsId(sql + parameterType, SqlCommandType.UPDATE);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
        newUpdateMappedStatement(msId, sqlSource, SqlCommandType.UPDATE);
        return msId;
    }

    public String delete(String sql) {
        String msId = newMsId(sql, SqlCommandType.DELETE);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        StaticSqlSource sqlSource = new StaticSqlSource(configuration, sql);
        newUpdateMappedStatement(msId, sqlSource, SqlCommandType.DELETE);
        return msId;
    }

    public String delete(String sql, Class<?> parameterType) {
        String msId = newMsId(sql + parameterType, SqlCommandType.DELETE);
        if (hasMappedStatement(msId)) {
            return msId;
        }
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, parameterType);
        newUpdateMappedStatement(msId, sqlSource, SqlCommandType.DELETE);
        return msId;
    }
}
