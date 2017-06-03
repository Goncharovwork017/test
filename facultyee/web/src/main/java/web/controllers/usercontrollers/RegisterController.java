package web.controllers.usercontrollers;

import by.goncharov.nc.dto.dto.UserDTO;
import by.goncharov.nc.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ivan on 02.06.2017.
 */


@RestController
public class RegisterController {

    private final Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        int id = userService.save(userDTO);
        logger.debug("User was successfully registered");
        return new ResponseEntity<>(new UserDTO(id, HttpStatus.CREATED.toString()), HttpStatus.CREATED);
    }


}
