package com.chenhm.doc.formatter.html;

import com.chenhm.doc.constant.HtmlConstants;
import com.chenhm.doc.formatter.Formatter;
import com.chenhm.doc.object.DocClassModel;
import com.chenhm.doc.object.DocFieldModel;
import com.chenhm.doc.object.DocMethodModel;
import com.chenhm.doc.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/12/15 16:38
 */
public class HtmlFormatter implements Formatter<DocClassModel> {


    @Override
    public String format(DocClassModel docClassModel) {

        StringBuffer sb = new StringBuffer();

        sb.append(HtmlConstants.HTML_HEADER).append(HtmlConstants.HTML_CSS).append(HtmlConstants.BODY_HEADER);

        DocumentTable documentTable = new DocumentTable();
        documentTable.addTitle(createTop());
        DocumentTR documentTR = new DocumentTR();
        DocumentTD documentTD1 = new DocumentTD(docClassModel.getVersion());
        DocumentTD documentTD2 = new DocumentTD(docClassModel.getAuthor());
        DocumentTD documentTD3 = new DocumentTD(docClassModel.getDate());
        DocumentTD documentTD4 = new DocumentTD(docClassModel.getClassDoc());

        documentTR.addTd(documentTD1);
        documentTR.addTd(documentTD2);
        documentTR.addTd(documentTD3);
        documentTR.addTd(documentTD4);

        documentTable.addTr(documentTR);
        String table4 = HtmlUtils.createTable(documentTable);
        DocumentTag tag10 = new DocumentTag("div",table4);
        tag10.put("style","margin-left: 20px;margin-top:40px");
        sb.append(HtmlUtils.createTag(tag10));

        if (docClassModel.getMethods() != null && docClassModel.getMethods().size() > 0) {
            for (DocMethodModel methodModel : docClassModel.getMethods()) {

                //功能描述
                sb.append(HtmlUtils.createTag(new DocumentTag("h1",methodModel.getMethodDoc())));
                DocumentTag tag1 = new DocumentTag("h3", "1) 功能描述");
                tag1.put("style","margin-left: 20px");
                sb.append(HtmlUtils.createTag(tag1));

                String content = HtmlUtils.createTag(new DocumentTag("label",methodModel.getMethodDoc())) + "</br>";
                DocumentTag tag2 = new DocumentTag("span", content);
                tag2.put("style","margin-left: 40px");

                sb.append(HtmlUtils.createTag(tag2));

                String url = "<label>地址：</label><a href=\"#\">${服务地址}/" + methodModel.getMethodName() + "</a>";

                DocumentTag tag3 = new DocumentTag("span", url);
                tag3.put("style","margin-left: 40px");
                sb.append(HtmlUtils.createTag(tag3));

                //请求输入参数
                DocumentTag tag4 = new DocumentTag("h3", "2) 请求输入参数");
                tag4.put("style","margin-left: 20px");
                sb.append(HtmlUtils.createTag(tag4));

                List<DocumentTR> documentTRS = filedTOTableList(methodModel.getParameters());
                DocumentTable table = new DocumentTable(documentTRS);
                table.addTitle(createTitle());
                String table1 = HtmlUtils.createTable(table);

                DocumentTag tag5 = new DocumentTag("div", table1);
                tag5.put("style","margin-left: 40px");
                sb.append(HtmlUtils.createTag(tag5));

                //响应参数
                DocumentTag tag6 = new DocumentTag("h3", "3) 响应参数");
                tag6.put("style","margin-left: 20px");
                sb.append(HtmlUtils.createTag(tag6));

                List<DocumentTR> documentTRS1 = filedTOTableList(methodModel.getReturnType().getFieldModels());
                DocumentTable table2 = new DocumentTable(documentTRS1);
                table2.addTitle(createTitle());
                String table3 = HtmlUtils.createTable(table2);

                DocumentTag tag7 = new DocumentTag("div", table3);
                tag7.put("style","margin-left: 40px");
                sb.append(HtmlUtils.createTag(tag7));
            }
        }

        sb.append(HtmlConstants.BODY_TAIL).append(HtmlConstants.HTML_TAIL);

        return sb.toString();
    }




    /**
     * 将List<DocFieldModel> 转为List<List<String>> table结构
     *
     * @param docFieldModels
     * @return
     */
    private List<DocumentTR> filedTOTableList(List<DocFieldModel> docFieldModels) {

        List<DocumentTR> tableList = new ArrayList<>();
        if (docFieldModels == null || docFieldModels.size() == 0) {
            return tableList;
        }
        for (DocFieldModel docFieldModel : docFieldModels) {

            tableList.add(new DocumentTR(filedTOTdList(docFieldModel)));
            //复杂对象 创建一个合并的单元格
            if (docFieldModel.getClassModel() != null){
                List<DocumentTR> lists = filedTOTableList(docFieldModel.getClassModel().getFieldModels());
                DocumentTable table = new DocumentTable(lists);
                table.addTitle(createTitle());
                String filedTable = HtmlUtils.createTable(table);
                DocumentTD filedTd = new DocumentTD(filedTable);
                filedTd.put("colspan","6");
                DocumentTR tr = new DocumentTR();
                tr.addTd(filedTd);
                tableList.add(tr);
            }
        }

        return tableList;
    }

    /**
     * filedModel 转为List<String> 一个<tr></tr>
     *
     * @param docFieldModel
     * @return
     */
    private List<DocumentTD> filedTOTdList(DocFieldModel docFieldModel) {

        List<DocumentTD> list = new ArrayList<>(6);

        list.add(new DocumentTD(docFieldModel.getFiledName()));
        list.add(new DocumentTD(docFieldModel.getFiledDoc()));
        list.add(new DocumentTD(docFieldModel.getSimpleTypeName()));
        list.add(new DocumentTD(""));
        list.add(new DocumentTD(""));
        list.add(new DocumentTD(""));

        return list;
    }

    /**
     * 创建表的标题
     *
     * @return
     */
    private DocumentTR createTitle() {


        List<DocumentTD> list = new ArrayList<>(6);

        list.add(new DocumentTD("字段名"));
        list.add(new DocumentTD("变量名"));
        list.add(new DocumentTD("类型"));
        list.add(new DocumentTD("说明"));
        list.add(new DocumentTD("可空"));
        list.add(new DocumentTD("样例"));

        DocumentTR documentTR = new DocumentTR(list);
//        documentTR.put("bgcolor","#69c");

        return documentTR;
    }

    /**
     * 创建表的标题
     *
     * @return
     */
    private DocumentTR createTop() {


        List<DocumentTD> list = new ArrayList<>(4);

        list.add(new DocumentTD("版本号"));
        list.add(new DocumentTD("作者"));
        list.add(new DocumentTD("修改时间"));
        list.add(new DocumentTD("说明"));

        DocumentTR documentTR = new DocumentTR(list);

        return documentTR;
    }
}
