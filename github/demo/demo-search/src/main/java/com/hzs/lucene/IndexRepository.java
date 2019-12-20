package com.hzs.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.*;
import java.nio.file.Path;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 索引存储
 * @date 2019/12/20 23:41
 */

public class IndexRepository {
    public static void main(String[] args) throws IOException {
        // 1.指定索引库的存放路径
        File indexRepositoryFile = new File("E:/demo/search/lucene/");
        Path path = indexRepositoryFile.toPath();
        Directory directory = FSDirectory.open(path);
        // 2.读取原始文档内容
        File files = new File("E:/demo/search/lucene/file/");
        // 3.创建分词器对象
        Analyzer analyzer = new StandardAnalyzer();
        // 4.创建IndexWriteConfig对象
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        // 5.创建IndexWrite对象，对索引库进行写操作
        IndexWriter indexWriter = new IndexWriter(directory, config);
        // 6.遍历一个文件
        for (File f : files.listFiles()) {
            // 文件名
            String fileName = f.getName();
            // 文件内容
            @SuppressWarnings("deprecation")
            String fileContent = FileUtils.readFileToString(f);
            // 文件路径
            String filePath = f.getPath();
            // 文件大小
            long fileSize = FileUtils.sizeOf(f);

            // 创建一个Document对象
            Document document = new Document();
            // document中添加域信息
            // 参数：1.域的名称 2.域的值 3.是否存储
            Field nameField = new TextField("name", fileName, org.apache.lucene.document.Field.Store.YES);
            Field contentField = new TextField("content", fileContent, org.apache.lucene.document.Field.Store.YES);
            // storeField默认存储
            Field pathField = new StoredField("path", filePath);
            Field sizeField = new StoredField("size", fileSize);
            // 将域添加到document对象中
            document.add(nameField);
            document.add(contentField);
            document.add(pathField);
            document.add(sizeField);
            // 将信息写入到索引库中
            indexWriter.addDocument(document);
        }
        // 关闭indexWriter
        indexWriter.close();
    }
}
