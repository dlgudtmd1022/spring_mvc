package com.spring.mvc.controller;

import com.spring.mvc.controller01.NotebookDTO;
import org.junit.jupiter.api.Test;

public class NoteBookDtoTest {
    @Test
    public void notebookTdoTest(){
        NotebookDTO notebook = new NotebookDTO();
        notebook.getRam();//getter 생성확인됨
        notebook.setModelNmae("MACBOOK PRO M2"); // setter 동작 여부 확인
        System.out.println("setter확인 : " + notebook); // toString() 생성여부 확인
    }
}
