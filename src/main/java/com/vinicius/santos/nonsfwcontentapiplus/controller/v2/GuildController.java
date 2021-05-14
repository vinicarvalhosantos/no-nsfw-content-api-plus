package com.vinicius.santos.nonsfwcontentapiplus.controller.v2;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.Guild;
import com.vinicius.santos.nonsfwcontentapiplus.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/guild")
public class GuildController {

    @Autowired
    GuildService guildService;

    @PostMapping("/create")
    public @ResponseBody
    ResponseEntity createGuild(@RequestBody Guild guild) {
        return ResponseEntity.status(HttpStatus.CREATED).body(guildService.createGuild(guild));
    }
}
