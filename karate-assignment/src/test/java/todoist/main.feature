@main
Feature: Test my app flow

  Scenario: Run my project

    * call read("projects/get-all-projects.feature")
    * call read("projects/create-project.feature")
    * call read("projects/get-project-by-id.feature")
    * call read("projects/update-project.feature")

  Scenario: Run section scenarios
    * call read('sections/create-section.feature')
    * call read('sections/get-all-sections.feature')
    * call read('sections/get-section-by-id.feature')
    * call read('sections/update-section.feature')


  Scenario: Run task scenarios
    * print "Running task scenarios"
    * call read('tasks/create-task.feature')
    * call read('tasks/get-all-tasks.feature')
    * call read('tasks/get-task-by-id.feature')
    * call read('tasks/update-task.feature')
    * call read('tasks/close-task.feature')
    * call read('tasks/reopen-task.feature')

  Scenario: Run comment scenarios
    * print "Running comment scenarios"
    * call read('comments/create-comment.feature')
    * call read('comments/get-all-comments.feature')
    * call read('comments/get-comment-by-id.feature')
    * call read('comments/update-comment.feature')

  Scenario: Run label scenarios
    * call read('labels/create-label.feature')
    * call read('labels/get-all-labels.feature')
    * call read('labels/get-label-by-id.feature')
    * call read('labels/update-label.feature')

  Scenario: Run cleanup features
    * call read('labels/delete-label.feature')
    * call read('comments/delete-comment.feature')
    * call read('tasks/delete-task.feature')
    * call read('sections/delete-section.feature')
    * call read("projects/delete-project.feature")
