function solution(record){
    let answer = [];

    let user = new Map();
    
    for(const message of record){
        let m = message.split(" ");
        // console.log(m);
        if(m[0] == 'Enter'){
            user.set(m[1],m[2])
        }else if(m[0] == 'Change'){
            user.set(m[1],m[2])
        }
    }

    for(const message of record){
        let m = message.split(" ");
        if(m[0] == 'Enter'){
            answer.push(user.get(m[1])+'님이 들어왔습니다.');
        }else if(m[0] == 'Leave'){
            answer.push(user.get(m[1])+'님이 나갔습니다.');
        }else if(m[0] == 'Change'){
            //answer.push(user.get(m[1])+'님이 들어왔습니다.');
        }else{
            console.log('error');
        }
    }
    // console.log(user)
    return answer;
}



record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"];
//["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

result1 = solution(record);
console.log(result1)