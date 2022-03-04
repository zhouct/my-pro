package com.zc.base.htmlparse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsoupDemo {

    public static void main(String[] args) throws IOException {

//        String filePath = "C:\\java\\workplace\\idea\\my-pro\\base\\src\\main\\java\\com\\zc\\base\\htmlparse\\私募基金公示 - 中国证券投资基金业协会.html";
//        Document document = Jsoup.parse(new File(filePath), "UTF-8");

        String rootUrl = "https://gs.amac.org.cn";
        String url = "https://gs.amac.org.cn/amac-infodisc/res/pof/fund/351000133588.html";
        String urlOrg = "https://gs.amac.org.cn/amac-infodisc/res/pof/manager/101000000138.html";
        HttpsUrlValidator.retrieveResponseFromServer(rootUrl);  // https链接需要先忽略证书
        Document document = Jsoup.connect(url).get();

        Elements title = document.getElementsByTag("title");
        System.out.println("title标签：" + title.first().text());
        List<String> strings = title.eachText();
        System.out.println(strings);

        Elements tds = document.getElementsByTag("td");
        List<String> tdTexts = tds.eachText();
        String fundName = "";
        for (int i = 0; i < tdTexts.size(); i++) {
            if("基金名称:".equals(tdTexts.get(i))){
                fundName = tdTexts.get(i + 1);
            }
        }

        System.out.println("基金名称：" + fundName);


        // 管理人信息
        Document documentOrg = Jsoup.connect(urlOrg).get();
        Elements tdOrgs = documentOrg.getElementsByTag("td");
        List<String> tdOrgTexts = tdOrgs.eachText();
        String orgName = "";
        for (int i = 0; i < tdOrgTexts.size(); i++) {
            if("基金管理人全称(中文)".equals(tdOrgTexts.get(i))){
                orgName = tdOrgTexts.get(i + 1);
            }
        }
        System.out.println("管理人名称：" + orgName);

    }


}
