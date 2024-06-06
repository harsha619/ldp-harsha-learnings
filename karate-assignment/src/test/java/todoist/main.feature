@main
Feature: Test my app flow

  Scenario: Run my project

    * call read("projects/project-list.feature")
    * call read("projects/create-project.feature")
    * call read("projects/get-project.feature")
    * call read("projects/update-project.feature")

  Scenario: Run section scenarios
    * call read('sections/create-section.feature')
    * call read('sections/section-list.feature')
    * call read('sections/section-by-id.feature')
    * call read('sections/update-section.feature')


  Scenario: Run task scenarios
    * print "Running task scenarios"
    * call read('tasks/create-task.feature')
    * call read('tasks/task-list.feature')
    * call read('tasks/task-by-id.feature')
    * call read('tasks/update-task.feature')
    * call read('tasks/close-task.feature')
    * call read('tasks/reopen-task.feature')

  Scenario: Run comment scenarios
    * print "Running comment scenarios"
    * call read('comments/create-comment.feature')
    * call read('comments/comment-list.feature')
    * call read('comments/comment-by-id.feature')
    * call read('comments/update-comment.feature')

  Scenario: Run label scenarios
    * call read('labels/create-label.feature')
    * call read('labels/label-list.feature')
    * call read('labels/label-by-id.feature')
    * call read('labels/update-label.feature')

  Scenario: Run cleanup features
    * call read('labels/delete-label.feature')
    * call read('comments/delete-comment.feature')
    * call read('tasks/delete-task.feature')
    * call read('sections/delete-section.feature')
    * call read("projects/delete-project.feature")
