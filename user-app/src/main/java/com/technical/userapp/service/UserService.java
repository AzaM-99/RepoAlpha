package com.technical.userapp.service;

import com.technical.userapp.dto.UserBasic;
import com.technical.userapp.exception.EntityNotFoundException;
import com.technical.userapp.exception.ManagementException;
import com.technical.userapp.mapper.UserMapper;
import com.technical.userapp.model.User;
import com.technical.userapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static com.technical.userapp.constant.UserConstants.*;

/**
 * This class is a service class that provides methods to perform CRUD operations on the User entity.
 */
@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * It saves a user to the database
     * 
     * @param userBasic The user object that is being saved.
     * @return UserBasic
     */
    public UserBasic save (UserBasic userBasic){

        log.debug("Request to save User : {}",userBasic);

        checkUserConsistency(userBasic);

        User user = mapper.toEntity(userBasic);

        return mapper.toBasic(repository.saveAndFlush(user));
    }


    /**
     * It returns a UserBasic object, which is a subset of the User object, and it does so by calling
     * the getOne() function, which returns a User object, and then it calls the toBasic() function,
     * which converts the User object into a UserBasic object
     * 
     * @param id The id of the user you want to get
     * @return A UserBasic object.
     */
    public @NotNull UserBasic getBasic(@NotNull Long id){
        return mapper.toBasic(getOne(id));
    }

    //Private classes//

    /**
     * 
     * @param id The id of the user to be retrieved
     * @return A User object
     */
    private @NotNull User getOne(@NotNull Long id){
        return this.repository.findById(id).orElseThrow(()-> new EntityNotFoundException("User",id));
    }

   /**
    * It checks if the user is valid and if not, it throws an exception
    * 
    * @param userBasic The user object that is being created
    */
    private void checkUserConsistency(UserBasic userBasic) {
        List<String> reasons = new ArrayList<>();

        if(userBasic.getId() != null){
            //To be used to update in case we have a user id instead of an exception
            reasons.add(USER_WITH_ID + userBasic.getId());
        }

        if("FRANCE".equalsIgnoreCase(userBasic.getCountry())){
            reasons.add(USER_NOT_FRENCH);
        }

        if(Period.between(userBasic.getBirthDate(), LocalDate.now()).getYears() < 18){
            reasons.add(USER_NOT_AN_ADULT);
        }

        if(!reasons.isEmpty()){
            throw new ManagementException(INVALID_USER_DATA,
                    reasons);
        }
    }
}
