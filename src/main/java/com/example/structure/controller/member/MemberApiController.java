package com.example.structure.controller.member;

import com.example.structure.global.api.ApiResponse;
import com.example.structure.global.api.DataResponse;
import com.example.structure.service.member.MemberService;
import com.example.structure.service.member.dto.request.MemberSaveRequest;
import com.example.structure.service.member.dto.response.MemberResponse;
import com.example.structure.service.member.dto.response.MemberWithTeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public ResponseEntity<ApiResponse> save(@RequestBody MemberSaveRequest request) {
        memberService.save(request);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @GetMapping("/api/v1/members")
    public ResponseEntity<DataResponse<List<MemberResponse>>> getMembers() {
        List<MemberResponse> members = memberService.getMembers();
        return ResponseEntity.ok(DataResponse.send(members));
    }

    @GetMapping("/api/v1/members/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        MemberResponse member = memberService.getMember(id);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/api/v1/members/{id}/all")
    public ResponseEntity<MemberWithTeamResponse> getMemberWithTeam(@PathVariable Long id) {
        MemberWithTeamResponse member = memberService.getMemberWithTeam(id);
        return ResponseEntity.ok(member);
    }

    @PatchMapping("/api/v1/members/{id}/join")
    public ResponseEntity<ApiResponse> join(@PathVariable Long id, @RequestParam("teamId") Long teamId) {
        memberService.join(teamId, id);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
