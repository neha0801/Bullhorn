import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import customTools.DBUtil;

import java.sql.*;
import java.util.*;

import model.Bullhorn;

public class Database {

	public static void insert(Bullhorn blog) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(blog);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}



	public static List<Bullhorn> getAllPost() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String sql = "select b from Bullhorn b order by b.postId desc";
		TypedQuery<Bullhorn> query= em.createQuery(sql, Bullhorn.class);
		List<Bullhorn> blog;
		try{
			blog=query.getResultList();
			if(blog==null||blog.isEmpty())
				blog=null;
		}finally{
			em.close();
		}		
		return blog;
	}

}
