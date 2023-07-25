local pid=KEYS[1];
local uid=KEYS[2];
local stockKey="kill_"..pid.."_sk";
local userKey="kill_"..pid.."_uk";
local stockEXISTS = redis.call('EXISTS',stockKey);
if stockEXISTS==0 then
    return 1;
end;
local num = redis.call('get',stockKey);
if tonumber(num)<=0 then
    return 2;
end;
local userEXISTS = redis.call('SISMEMBER',userKey,uid);
if userEXISTS==1 then
    return 3;
else
    redis.call('decr',stockKey);
    redis.call('sadd',userKey,uid);
    return 4;
end;
