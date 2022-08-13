package com.example.hotels.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomType {

    KING_ROOM("KRAL ODASI"),
    STANDARD("STANDART"),
    SEA_VIEW("DENIZ MANZARALI");

    private final String label;

}
