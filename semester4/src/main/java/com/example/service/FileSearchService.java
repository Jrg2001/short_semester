package com.example.service;

import com.example.search.DocKeywordSearch;
import com.example.search.FileSearch;
import com.example.search.PdfKeywordSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

import static com.example.search.FileSearch.getFileExtension;

@Service
public class FileSearchService {
    private final DocKeywordSearch docKeywordSearch;
    private final PdfKeywordSearch pdfKeywordSearch;

    @Autowired
    public FileSearchService(DocKeywordSearch docKeywordSearch, PdfKeywordSearch pdfKeywordSearch) {
        this.docKeywordSearch = docKeywordSearch;
        this.pdfKeywordSearch = pdfKeywordSearch;
    }

    public String searchAndProcessFiles(String keyword) {
        StringBuilder outputContent = new StringBuilder();

        FileSearch fs = new FileSearch();
        List<String> filePath = fs.getFilePath();

        for (String s : filePath) {
            File file = new File(s);
            String extension = getFileExtension(file.getName());

            if (extension.equalsIgnoreCase("doc")) {
                // ... 处理 doc 文件
                System.out.println(s);

                outputContent.append("\n");
                outputContent.append(s).append("\n");
                outputContent.append("---------------------------------------").append("\n");
                System.out.println("------------------------------------------------------------------------");
                // docKeywordSearch.doSearch(s,keyword);
                List<String> strings = docKeywordSearch.doSearch(s, keyword);
                for (String string : strings) {
                    outputContent.append(string).append("\n");
                }
                outputContent.append("\n");

            } else if (extension.equalsIgnoreCase("pdf")) {
                // ... 处理 pdf 文件

                outputContent.append("\n");
                outputContent.append(s).append("\n");
                outputContent.append("---------------------------------------").append("\n");

                System.out.println(s);
                System.out.println("------------------------------------------------------------------------");
                //pdfKeywordSearch.pdfSearch(s,keyword);
                List<String> strings = pdfKeywordSearch.pdfSearch(s, keyword);
                for (String string : strings) {
                    outputContent.append(string).append("\n");
                }
                outputContent.append("\n");

            } else {
                // ... 处理其他文件类型
                System.out.println("Unsupported file type: " + extension);
            }
            System.out.println();
        }

        return outputContent.toString();
    }
}
