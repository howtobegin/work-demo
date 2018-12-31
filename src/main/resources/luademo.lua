redis.call('set', 'luademo1', 1)
redis.call('set', 'luademo2', null)
redis.call('set', 'luademo3', 3)

local ret = redis.call('get', 'luademo1')
return ret