package com.vinicius.santos.nonsfwcontentapiplus.controller.v2;

import com.vinicius.santos.nonsfwcontentapiplus.model.entity.UserGuilds;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.GuildUsersView;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.UserGuildsCreatedView;
import com.vinicius.santos.nonsfwcontentapiplus.model.to.UserGuildsView;
import com.vinicius.santos.nonsfwcontentapiplus.service.UserGuildsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/v1/user-guilds")
public class UserGuildsController {

    @Autowired
    UserGuildsService userGuildsService;

    @PostMapping("/create")
    public @ResponseBody
    ResponseEntity linkUserToGuild(@RequestBody UserGuilds userGuilds) {
        try {
            UserGuildsCreatedView userGuildsCreatedView = userGuildsService.createUserGuilds(userGuilds);
            if (userGuildsCreatedView != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(userGuildsCreatedView);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("GUILD_OR_USER_NOT_FOUND");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @GetMapping("/user/{userId}")
    public @ResponseBody
    ResponseEntity getUserGuilds(@PathVariable("userId") Long userId) {
        try {
            UserGuildsView userGuildsView = userGuildsService.getUserGuilds(userId);
            if(userGuildsView != null){
                return ResponseEntity.status(HttpStatus.OK).body(userGuildsView);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER_NOT_FOUND");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @GetMapping("/guild/{guildId}")
    public @ResponseBody
    ResponseEntity getGuildUsers(@PathVariable("guildId") Long guildId) {
        try {
            GuildUsersView guildUsersView = userGuildsService.getGuildUsers(guildId);
            if (guildUsersView != null) {
                return ResponseEntity.status(HttpStatus.OK).body(guildUsersView);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("GUILD_NOT_FOUND");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

    }

    @DeleteMapping("/delete/user/{userId}/guild/{guildId}")
    public @ResponseBody
    ResponseEntity deleteUserFromGuild(@PathVariable("userId") Long userId, @PathVariable("guildId") Long guildId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userGuildsService.deleteUserFromGuilds(userId, guildId));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}
