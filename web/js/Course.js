const getCourseById = async (id) => {
    var course;
    await $.post(
        "GetCourseById",
        {
            course_id: id
        }
    ).done((data, status) => {
        course = data;
    });

    // console.log(course);

    return new Promise((res, rej)=>{
        res(JSON.parse(course));
    })
}

const getCourseByTeacherId = async () => {
    var course;
    await $.post(
        "GetCourseByTeacherId",
    ).done((data, status) => {
        course = data;
    });

    // console.log(course);

    return new Promise((res, rej)=>{
        res(JSON.parse(course));
    })
}