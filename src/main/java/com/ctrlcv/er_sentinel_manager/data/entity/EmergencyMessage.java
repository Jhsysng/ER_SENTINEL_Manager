package com.ctrlcv.er_sentinel_manager.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmergencyMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dutyId")
    private Hospital hospital;

    private String emgMessage;

    private LocalDateTime emgMsgStartTime;

    private LocalDateTime emgMsgEndTime;

    private String emgMsgType;

    @Builder
    public EmergencyMessage(int id, Hospital hospital, String emgMessage, LocalDateTime emgMsgStartTime, LocalDateTime emgMsgEndTime, String emgMsgType) {
        this.id = id;
        this.hospital = hospital;
        this.emgMessage = emgMessage;
        this.emgMsgStartTime = emgMsgStartTime;
        this.emgMsgEndTime = emgMsgEndTime;
        this.emgMsgType = emgMsgType;
    }
}
