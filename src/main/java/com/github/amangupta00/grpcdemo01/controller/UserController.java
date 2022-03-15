package com.github.amangupta00.grpcdemo01.controller;

import com.github.amangupta00.grpcdemo01.model.User;
import com.github.amangupta00.grpcdemo01.service.UserService;
import com.github.amangupta00.grpcdemo01.stubs.user.InsertUserRequest;
import com.github.amangupta00.grpcdemo01.stubs.user.UserRequest;
import com.github.amangupta00.grpcdemo01.stubs.user.UserResponse;
import com.github.amangupta00.grpcdemo01.stubs.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class UserController extends UserServiceGrpc.UserServiceImplBase {
    @Autowired
    private UserService userService;

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = userService.getUserForUserId(request.getUsername());

        UserResponse.Builder userResponseBuilder =
                UserResponse.newBuilder()
                        .setId(user.getId())
                        .setUsername(user.getUsername())
                        .setName(user.getName())
                        .setAge(user.getAge())
                        .setGender(user.getGender());
        UserResponse userResponse = userResponseBuilder.build();

        responseObserver.onNext(userResponse);          //Return call
        responseObserver.onCompleted();
    }

}
