package com.example.eo_neo.domain.user.service;

import com.example.eo_neo.domain.user.domain.User;
import com.example.eo_neo.global.security.auth.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPlanService {
    public List<List<String>> excute() {
        UsernamePasswordAuthenticationToken contextInfo = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Details details = (Details) contextInfo.getPrincipal();
        User user = details.getUser();

        List<List<String>> list = new ArrayList<>();

        for (String s : user.getPlan()) {
            String trim = s.substring(1, s.length() - 1);
            String[] e = trim.split(",");
            list.add(Arrays.asList(e));
        }
        return list;
    }
}
