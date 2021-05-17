package org.hdcd.devproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.hdcd.devproject.domain.Board;
import org.hdcd.devproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/register")
    public void registerForm(Board board, Model model) throws Exception {
        log.info("registerForm");
    }

    @PostMapping("/register")
    public String register(Board board, Model model) throws Exception {
        log.info("register");

        service.register(board);

        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "board/success";
    }

    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list");

        model.addAttribute("list", service.list());
    }

    @GetMapping("/read")
    public void read(int boardNo, Model model) throws Exception {
        log.info("read");

        model.addAttribute(service.read(boardNo));
    }

    @PostMapping("/remove")
    public String remove(int boardNo, Model model) throws Exception {
        log.info("remove");

        service.remove(boardNo);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "board/success";
    }

    @GetMapping("/modify")
    public void modifyForm(int boardNo, Model model) throws Exception {
        log.info("modifyForm");

        model.addAttribute(service.read(boardNo));
    }

    @PostMapping("/modify")
    public String modify(Board board, Model model) throws Exception {
        log.info("modify");

        service.modify(board);

        model.addAttribute("msg", "수정이 완료되었습니다.");

        return "board/success";
    }

}
