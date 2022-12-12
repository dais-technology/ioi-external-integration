drop index idx_qrtz_j_req_recovery on qrtz_job_details( sched_name, requests_recovery );
drop index idx_qrtz_j_grp on qrtz_job_details( sched_name, job_group );

drop index idx_qrtz_t_j on qrtz_triggers( sched_name, job_name, job_group );
drop index idx_qrtz_t_jg on qrtz_triggers( sched_name, job_group );
drop index idx_qrtz_t_c on qrtz_triggers( sched_name, calendar_name );
drop index idx_qrtz_t_g on qrtz_triggers( sched_name, trigger_group );
drop index idx_qrtz_t_state on qrtz_triggers( sched_name, trigger_state );
drop index idx_qrtz_t_n_state on qrtz_triggers( sched_name, trigger_name, trigger_group, trigger_state );
drop index idx_qrtz_t_n_g_state on qrtz_triggers( sched_name, trigger_group, trigger_state );
drop index idx_qrtz_t_next_fire_time on qrtz_triggers( sched_name, next_fire_time );
drop index idx_qrtz_t_nft_st on qrtz_triggers( sched_name, trigger_state, next_fire_time );
drop index idx_qrtz_t_nft_misfire on qrtz_triggers( sched_name, misfire_instr, next_fire_time );
drop index idx_qrtz_t_nft_st_misfire on qrtz_triggers( sched_name, misfire_instr, next_fire_time, trigger_state );
drop index idx_qrtz_t_nft_st_misfire_grp on qrtz_triggers( sched_name, misfire_instr, next_fire_time, trigger_group,
                                                             trigger_state );

drop index idx_qrtz_ft_trig_inst_name on qrtz_fired_triggers( sched_name, instance_name );
drop index idx_qrtz_ft_inst_job_req_rcvry on qrtz_fired_triggers( sched_name, instance_name, requests_recovery );
drop index idx_qrtz_ft_j_g on qrtz_fired_triggers( sched_name, job_name, job_group );
drop index idx_qrtz_ft_jg on qrtz_fired_triggers( sched_name, job_group );
drop index idx_qrtz_ft_t_g on qrtz_fired_triggers( sched_name, trigger_name, trigger_group );
drop index idx_qrtz_ft_tg on qrtz_fired_triggers( sched_name, trigger_group );

drop table qrtz_locks;
drop table qrtz_scheduler_state;
drop table qrtz_fired_triggers;
drop table qrtz_paused_trigger_grps;
drop table qrtz_calendars;
drop table qrtz_blob_triggers;
drop table qrtz_simprop_triggers;
drop table qrtz_simple_triggers;
drop table qrtz_triggers;
drop table qrtz_job_details;