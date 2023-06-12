package com.example.eo_neo.domain.question.service;

import com.example.eo_neo.domain.user.domain.QuestionCategory;
import com.example.eo_neo.domain.user.domain.User;
import com.example.eo_neo.domain.user.domain.repository.UserRepository;
import com.example.eo_neo.global.security.auth.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PutCorrect {

    private final UserRepository userRepository;

    public void execute(QuestionCategory category){
        UsernamePasswordAuthenticationToken contextInfo = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Details details = (Details) contextInfo.getPrincipal();
        User user = details.getUser();
        if (category.equals(QuestionCategory.BASIC)) {
            user.setCorrectBasic(user.getCorrectBasic() + 1);
            userRepository.save(user); // lombok의 annotation인 @Setter로 만들어진 setter method는 값을 저장하는 기능만을 지닌 method일 뿐 자기자신을 반환하지 않습니다. 위와 같은 코드에서 user.setCorrectBasic()은 void를 반환하기 때문에  정상적으로 userRepository.save() method가 작동하지 않은 것입니다. user.set... method로 user의 값을 바꾸고 그 user를 다시한번 저장하는 것으로 해당 장애를 해결했습니다.
            // 오류가 발생한 코드 : userRepository.save(user.setCorrectBasic(user.getCorrectBasic() + 1));
        } else if (category.equals(QuestionCategory.WORD)) {
            user.setCorrectWord(user.getCorrectWord() + 1);
            userRepository.save(user);
        }else if (category.equals(QuestionCategory.CONVERSATION)) {
            user.setCorrectConversation(user.getCorrectConversation() + 1);
            userRepository.save(user);
        }else if (category.equals(QuestionCategory.LANGUAGE)) {
            user.setCorrectLanguage(user.getCorrectLanguage() + 1);
            userRepository.save(user);
        }
    }
}
