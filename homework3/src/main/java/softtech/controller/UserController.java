package softtech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softtech.dto.UserDto;
import softtech.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public ResponseEntity createUser(@RequestBody UserDto userDto){
       return ResponseEntity.ok(userService.createUser(userDto));
    }
    @PutMapping("/api/v1/user/{userId}")
    public ResponseEntity updateUser(@PathVariable Long id,@RequestBody UserDto userDto){
       return ResponseEntity.ok(userService.updateUser(id,userDto));
    }

    @GetMapping("/api/v1/userList")
    public ResponseEntity getUserList(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/api/v1/userbyname/{userName}")
    public ResponseEntity getUserByName(@PathVariable String userName){
        return ResponseEntity.ok(userService.getUserByName(userName));
    }
    @DeleteMapping("api/v1/user/{userName}")
    public void deleteUser(@PathVariable String userName, @RequestParam Long phoneNumber){
        userService.deleteUserByName(userName,phoneNumber);
    }

}
