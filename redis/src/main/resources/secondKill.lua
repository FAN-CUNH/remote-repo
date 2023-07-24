local pid=Keys[1];
local uid=Keys[2];
local stockKey="kill_"..pid.."_sk";
local userKey="kill_"..pid.."_uk";
local stockExists = redis.call('EXISTS',stockKey);
if stockEXISTS==0 then
    return 1;
end;
local num = redis.call('get',stockKey);
if toNumber(num)<=0 then
    return 2;
end;
local userExists = redis.call('SISMEMBER',userKey,uid);
if userExists==1 then
    return 3;
else
    redis.call('decr',stockKey);
    redis.call('sadd',userKey,uid);
    return 4;
end;