function solution(lines) {
    let timeTable = [];
    for(const line of lines){
        l = line.split(" ");
        let time = l[1].split(":");
        let end_h = parseInt(time[0]);
        let end_m = parseInt(time[1]);
        let end_s = parseFloat(time[2]);

        let end = end_h*60*60 + end_m*60 + end_s
        let start =  Math.round((end - l[2].slice(0,-1) + parseFloat(0.001))*1000) / 1000;

        timeTable.push([start,end])
    }
    // console.log(timeTable)

    let count = 0;
    let start_count;
    let end_count;
    for(const index in timeTable){
        let end_pivot = timeTable[index][1] + 1;
        end_count = 1;
        // console.log('index : ',index,'start_end : ',start_pivot,' end_end : ',end_pivot) 

        for(let i=parseInt(index)+1; i<timeTable.length; i++){
            if(end_pivot > timeTable[i][0] ){ //다음 통신의 시작시간보다
                end_count += 1;
                continue;
            }
            if(end_pivot > timeTable[i][1] ){ //다음 통신의 종료시간보디 
                end_count += 1;
                continue;
            }
        }     
        // console.log(count,start_count,end_count) 
        if(end_count > count){
            count = end_count;
        }   
    }
    return count;
}

function other_solution(lines) {
    let answer = 0;

    for(var i=0; i < (lines.length - answer); i++){
        let Time = function (timeline){
            // Date 객체 생성
            let endDate = new Date(timeline.substring(0,timeline.lastIndexOf(" "))); // timeline.lastIndexOf(" ") : " "의 index 반환
            let processingTime = timeline.substring(timeline.lastIndexOf(" ")+1, timeline.length-1)*1000; //1000ms = 1s -> *1000
            this.endTime = endDate.getTime();
            //getTime() - Unix 타임 : 1970/1/1 12:00 기준 경과한 밀리 초

            this.startTime = this.endTime - processingTime + 1;
        }

        let basisTime = new Time(lines[i]).endTime + 1000;
        let num = 1;

        for(let j=i+1; j < lines.length; j++){
            let target = new Time(lines[j]);

            if(target.startTime < basisTime){
                num++;
            }
        }

        if(num > answer){
            answer = num;
        }
    }
    return answer;
}

lines =  [
    "2016-09-15 01:00:04.001 2.0s",
    "2016-09-15 01:00:07.000 2s"
    ]; // 1
lines =  [
    "2016-09-15 01:00:04.002 2.0s",
    "2016-09-15 01:00:07.000 2s"
    ]; // 2

result1 = solution(lines);
console.log(result1);

result2 = other_solution(lines);
console.log(result2);