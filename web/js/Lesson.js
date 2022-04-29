const getLessonByLessonId = async (id) => {
    var lesson;
    await $.post(
        "GetLessonById",
        {
            lesson_id: id
        }
    ).done((data, status) => {
        lesson = data;
    });

    return new Promise((res, rej) => {
        res(JSON.parse(lesson));
    })
}

const getAllLesson = async () => {
    var lesson;
    await $.post(
        "GetAllLesson",
    ).done((data, status) => {
        lesson = data;
    });

    // console.log(lesson);

    return new Promise((res, rej) => {
        res(JSON.parse(lesson));
    })
}

const createNewLesson = async (course_id) => {
    var lesson;
    await $.post(
        "CreateLesson",{
            course_id: course_id
        }
    ).done((data, status) => {
        lesson = data;
    });

    console.log("new Lesson", lesson);

    return new Promise((res, rej) => {
        res(JSON.parse(lesson));
    })
}

const updateLesson = async (lesson_id, lesson_name, lesson_date, time_started, time_ended) => {
    var lesson;
    await $.post(
        "UpdateLesson",{
            lesson_id: lesson_id,
            lesson_name: lesson_name,
            lesson_date: lesson_date,
            time_started: time_started,
            time_ended: time_ended,
        }
    ).done((data, status) => {
        lesson = data;
    });

    // console.log("updated Lesson", lesson);

    return new Promise((res, rej) => {
        res(JSON.parse(lesson));
    })
}
