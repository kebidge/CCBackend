package de.kebidge.hft.dpt.ccbackend; 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CcBackendController {

    @Autowired
    CcBackendUserRepository userRepository; 
    
    Logger logger = LoggerFactory.getLogger(CcBackendController.class);

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/user/add")
    public CcBackendUserEntity addUserRequestBody(@RequestBody CcBackendUserEntity newUser) {

        userRepository.save(newUser);

        logger.info("----- ADD User -----");    
        logger.info("new id = {}", newUser.id);
        logger.info("new username = {}", newUser.username);

        return newUser;
    }
 
    @GetMapping("/user")
    public List<Optional<CcBackendUserEntity>> getUser() {
     
        Iterable<CcBackendUserEntity> iterableUser = userRepository.findAll();
 
        List<String> userList = new ArrayList<String>();
        List<Optional<CcBackendUserEntity>> optionalUserList = new ArrayList<Optional<CcBackendUserEntity>>();
         
        Iterator<CcBackendUserEntity> userIterator = iterableUser.iterator();

        logger.info("----- GET User -----");

        while(userIterator.hasNext()){
            CcBackendUserEntity tempUser = userIterator.next();
            Optional<CcBackendUserEntity> optionalTempUser = userRepository.findById(tempUser.id);
            userList.add(tempUser.username);
            optionalUserList.add(optionalTempUser);
            logger.info("id = {}", optionalTempUser.get().id);
            logger.info("username = {}", optionalTempUser.get().username);

        }
 
        return optionalUserList; 
    }   
    
}
