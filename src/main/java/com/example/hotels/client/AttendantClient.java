package com.example.hotels.client;

import com.example.hotels.dto.JobsSaveRequestDTO;
import com.example.hotels.dto.PersonnelSaveRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "hotelAttendants", url = "http://localhost:8081/management")
public interface AttendantClient {

    @PostMapping("/jobs/save")
    void jobsSave(JobsSaveRequestDTO dto);

    @PostMapping("/personnel/save")
    void personnelSave(PersonnelSaveRequestDTO personnelSaveRequestDTO);

}
