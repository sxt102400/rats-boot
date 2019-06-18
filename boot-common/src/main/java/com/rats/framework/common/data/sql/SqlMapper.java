package com.rats.framework.common.data.sql;



import com.rats.framework.common.data.DataMap;
import com.rats.framework.common.data.DataSet;
import com.rats.framework.common.data.DataSetList;
import com.rats.framework.common.data.DataTable;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.executor.result.DefaultMapResultHandler;
import org.apache.ibatis.executor.result.DefaultResultContext;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.Iterator;
import java.util.List;

/**
 * SqlMapper
 */
public class SqlMapper {

    private SqlSession sqlSession;
    private Configuration configuration;
    private SqlMappedStatementHandler handler;

    public SqlMapper(SqlSession sqlSession) {
        this.configuration = sqlSession.getConfiguration();
        this.handler = new SqlMappedStatementHandler(sqlSession.getConfiguration());
    }

    public DataSet selectList(String sql) {
        String statement = handler.selectList(sql);
        List list = sqlSession.selectList(statement);
        return new DataSetList(sqlSession.selectList(statement));
    }

    public DataSet selectList(String sql, Object parameter) {
        Class<?> parameterType = parameter != null ? parameter.getClass() : null;
        String statement = handler.selectList(sql, parameterType);
        return  new DataSetList(sqlSession.selectList(statement,parameter));
    }

    public DataSet selectList(String sql, Object parameter, RowBounds rowBounds) {
        Class<?> parameterType = parameter != null ? parameter.getClass() : null;
        String statement = handler.selectList(sql, parameterType);
        return  new DataSetList(sqlSession.selectList(statement, parameter,rowBounds));
    }

    public DataTable selectOne(String sql) {
        return selectOne(sql, (Object)null);
    }

    public DataTable selectOne(String sql, Object parameter) {
        List<DataTable> list = this.selectList(sql, parameter);
        if(list.size() == 1) {
            return list.get(0);
        } else if(list.size() > 1) {
            throw new TooManyResultsException("Expected one result (or null) to be returned by selectOne(), but found: " + list.size());
        } else {
            return null;
        }
    }

    public DataTable selectMap(String sql, String mapKey) {
        return selectMap(sql, (Object)null, mapKey, RowBounds.DEFAULT);
    }

    public DataTable selectMap(String sql, Object parameter, String mapKey) {
        return selectMap(sql, parameter, mapKey, RowBounds.DEFAULT);
    }

    public DataTable selectMap(String sql, Object parameter, String mapKey, RowBounds rowBounds) {
        List<DataTable> list = selectList(sql, parameter, rowBounds);
        DefaultMapResultHandler mapResultHandler = new DefaultMapResultHandler(mapKey, this.configuration.getObjectFactory(), this.configuration.getObjectWrapperFactory(), this.configuration.getReflectorFactory());
        DefaultResultContext context = new DefaultResultContext();
        Iterator<DataTable> iter = list.iterator();
        DataTable data = new DataMap();
        while(iter.hasNext()) {
            data = iter.next();
        }
        return data;
    }


    public int insert(String sql) {
        String statement = handler.insert(sql);
        return sqlSession.insert(statement);
    }

    public int insert(String sql, Object parameter) {
        Class<?> parameterType = parameter != null ? parameter.getClass() : null;
        String statement = handler.insert(sql, parameterType);
        return sqlSession.update(statement, parameter);
    }

    public int update(String sql) {
        String statement = handler.update(sql);
        return sqlSession.update(statement);
    }

    public int update(String sql, Object parameter) {
        Class<?> parameterType = parameter != null ? parameter.getClass() : null;
        String statement = handler.update(sql, parameterType);
        return sqlSession.update(statement, parameter);
    }

    public int delete(String sql) {
        String statement = handler.delete(sql);
        return this.delete(statement);
    }

    public int delete(String sql, Object parameter) {
        Class<?> parameterType = parameter != null ? parameter.getClass() : null;
        String statement = handler.update(sql, parameterType);
        return this.update(statement, parameter);
    }

}
