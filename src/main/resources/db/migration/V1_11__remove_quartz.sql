drop index idx_qrtz_j_req_recovery;
drop index idx_qrtz_j_grp;

drop index idx_qrtz_t_j;
drop index idx_qrtz_t_jg;
drop index idx_qrtz_t_c;
drop index idx_qrtz_t_g;
drop index idx_qrtz_t_state;
drop index idx_qrtz_t_n_state;
drop index idx_qrtz_t_n_g_state;
drop index idx_qrtz_t_next_fire_time;
drop index idx_qrtz_t_nft_st;
drop index idx_qrtz_t_nft_misfire;
drop index idx_qrtz_t_nft_st_misfire;
drop index idx_qrtz_t_nft_st_misfire_grp;

drop index idx_qrtz_ft_trig_inst_name;
drop index idx_qrtz_ft_inst_job_req_rcvry;
drop index idx_qrtz_ft_j_g;
drop index idx_qrtz_ft_jg;
drop index idx_qrtz_ft_t_g;
drop index idx_qrtz_ft_tg;

drop table qrtz_locks;
drop table qrtz_scheduler_state;
drop table qrtz_fired_triggers;
drop table qrtz_paused_trigger_grps;
drop table qrtz_calendars;
drop table qrtz_blob_triggers;
drop table qrtz_simprop_triggers;
drop table qrtz_cron_triggers;
drop table qrtz_simple_triggers;
drop table qrtz_triggers;
drop table qrtz_job_details;