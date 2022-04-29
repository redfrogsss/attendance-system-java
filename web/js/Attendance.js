const getAllAttendance = async () => {
    var attendance;
    await $.post(
        "GetAllAttendance"
    ).done((data, status) => {
        attendance = data;
    });

    // console.log("attendance", attendance);

    return new Promise((res, rej)=>{
        res(JSON.parse(attendance));
    })
};

const getAttendanceById = async (id) => {
    var attendance;
    await $.post(
        "GetAttendanceById",
        {
            attendance_id: id
        }
    ).done((data, status) => {
        attendance = data;
    });

    // console.log(attendance);

    return new Promise((res, rej)=>{
        res(JSON.parse(attendance));
    })
};

const getAttendanceByLessonId = async (id) => {
    var attendance;
    await $.post(
        "GetAttendanceByLessonId",
        {
            lesson_id: id
        }
    ).done((data, status) => {
        attendance = data;
    });

    // console.log(attendance);

    return new Promise((res, rej)=>{
        res(JSON.parse(attendance));
    })
};

const createAttendance = async (lesson_id) => {
    var attendance;
    await $.post(
        "CreateAttendance",
        {
            lesson_id: lesson_id
        }
    ).done((data, status) => {
        attendance = data;
    });

    // console.log(attendance);

    return new Promise((res, rej)=>{
        res(JSON.parse(attendance));
    })
};

const getUserAttendance = async (lesson_id) => {
    var attendance;
    await $.post(
        "GetUserAttendance",
        {
            lesson_id: lesson_id
        }
    ).done((data, status) => {
        attendance = data;
    });

    // console.log(attendance);

    return new Promise((res, rej)=>{
        res(JSON.parse(attendance));
    })
};

const updateAttendance = async (lesson_id, student_id, status) => {
    var result;
    await $.post(
        "UpdateAttendance",
        {
            lesson_id: lesson_id,
            student_id: student_id,
            status: status,
        }
    ).done((data, status) => {
        result = data;
    });

    console.log(attendance);

    return new Promise((res, rej)=>{
        res(result);
    })
}; 