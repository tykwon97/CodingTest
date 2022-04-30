function solution(id_list, reports, k) {
    let answer = new Array(id_list.length);
    let mail_count = new Array(id_list.length);
    let user_count = new Array(id_list.length);
    for (let i = 0; i < id_list.length; i++) {
        answer[i] = 0;
        mail_count[i] = 0;
        user_count[i] = '';
    }
    for (const report of reports){
        x = report.split(" ");
        for (let i in id_list){
            if(id_list[i] == x[1]){
                mail_count[i]++;
                user_count[i] += (x[0]+" "); 
            }
        }
    }
    for(let i=0; i<id_list.length; i++){
        if(mail_count[i] >= k){
            x = user_count[i].split(" ");
            for (let j=0; j<x.length; j++){
                for (let k in id_list){
                    if(id_list[k] == x[j]){
                        answer[k]++;
                    }
                }
            }

            
        }
    }
    return answer;
}

let id_list = ["muzi", "frodo", "apeach", "neo"];
let report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"];
let k = 2;

let result = solution(id_list,report,k);
console.log(result);
