const getTeacherByCourseId = async (id) => {
    var teacher;
    await $.post(
        "GetTeacherByCourseId",
        {
            course_id: id
        }
    ).done((data, status) => {
        teacher = data;
    });

    // console.log("teacher", teacher);

    return new Promise((res, rej) => {
        res(JSON.parse(teacher));
    })
}

const getAllStudents = async () => {
    var students;
    await $.post(
        "GetAllStudents"
    ).done((data, status) => {
        students = data;
    });

    return new Promise((res, rej) => {
        res(JSON.parse(students));
    })
}