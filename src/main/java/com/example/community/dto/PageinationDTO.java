package com.example.community.dto;

import java.util.List;

public class PageinationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFristPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages;

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public boolean isShowPrevious() {
        return showPrevious;
    }

    public void setShowPrevious(boolean showPrevious) {
        this.showPrevious = showPrevious;
    }

    public boolean isShowFristPage() {
        return showFristPage;
    }

    public void setShowFristPage(boolean showFristPage) {
        this.showFristPage = showFristPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowEndPage() {
        return showEndPage;
    }

    public void setShowEndPage(boolean showEndPage) {
        this.showEndPage = showEndPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public  void setPageination(Integer count, Integer page, Integer size) {
        Integer totaPage=0;
        if (count%size==0){
            totaPage=count/size;
        }else {
            totaPage=count/size+1;
        }

        //是否展示上一页
        if (page==1){
            showPrevious=false;

        }else {
            showPrevious=true;
        }

        //是否展示下一页
        if (page==count){
            showNext=false;
        }else {
            showNext=true;
        }
        //是否展示第一页
        if(pages.contains(1)){
            showFristPage=false;
        }else {
            showFristPage=true;
        }
        if (pages.contains(count)){
            showEndPage=false;
        }else {
            showEndPage=true;
        }
    }
}
