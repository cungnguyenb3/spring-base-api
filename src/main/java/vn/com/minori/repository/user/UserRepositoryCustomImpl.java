package vn.com.minori.repository.user;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextQuery;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

import vn.com.minori.domain.User;

public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> search(String keyword) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(User.class)
                .get();

        Query query = queryBuilder.keyword()
                .onFields("name", "email", "phone")
                .matching(keyword)
                .createQuery();

        FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(query, User.class);

        return jpaQuery.getResultList();
    }
}
