package com.hzs.lucene;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 文档搜索
 * @date 2019/12/21 0:07
 */

public class DocSearch {
    public static void main(String[] args) throws IOException {
        // 1.打开索引库
        File indexRepositoryFile = new File("E:/demo/search/lucene/");
        Path path = indexRepositoryFile.toPath();
        Directory directory = FSDirectory.open(path);
        IndexReader indexReader = DirectoryReader.open(directory);
        // 2.创建IndexSearch对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 3.创建一个查询对象
        TermQuery query = new TermQuery(new Term("name", "file2"));
        // 4.执行查询
        // 返回最大值，分页使用
        TopDocs topDocs = indexSearcher.search(query, 5);
        // 5.取出查询总数量
        System.out.println("总共查询的结果总数：" + topDocs.totalHits);
        // 6.查询结果
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs ) {
            // 获取document的id
            int docId = scoreDoc.doc;

            // 相关度得分
            float score = scoreDoc.score;

            // 根据id获取document对象
            Document document = indexSearcher.doc(docId);
            System.out.println("相关度得分：" + score);
            System.out.println(document.get("name"));

            // 另外一种获取文档方法
            System.out.println(document.getField("content").stringValue());
            System.out.println(document.get("path"));
            System.out.println("=========");

        }

    }
}
