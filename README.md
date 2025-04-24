# TaskTracker

<div class="mb-4 rounded-lg border bg-linear-to-b from-gray-100 to-white to-10% p-4 py-2 sm:p-5"> <div class="relative"> <div class="mb-4 hidden items-center justify-between sm:flex"> <div class="flex flex-row flex-wrap gap-1.5"> <span class="rounded-md border capitalize bg-green-100 text-green-700 border-green-200 px-1 py-0.5 text-xs tracking-wide">Programming Language -> Java <br></span><span class="rounded-md border capitalize bg-green-100 text-green-700 border-green-200 px-1 py-0.5 text-xs tracking-wide"></span><span class="rounded-md border capitalize bg-green-100 text-green-700 border-green-200 px-1 py-0.5 text-xs tracking-wide"></span> </div> <span class="rounded-md border capitalize bg-yellow-100 text-yellow-700 border-yellow-200 px-1 py-0.5 text-xs tracking-wide">Lvl - 1</span> </div> <div class="my-2 flex items-center justify-between gap-2 sm:my-7"> <div class="">
<p class="text-sm text-balance text-gray-500"> Build a CLI app to track your tasks and manage your to-do list. </p> </div>  </div> </div> <astro-island uid="ZcJdku" prefix="r13" component-url="/_astro/ProjectStepper.DVJDYZDp.js" component-export="ProjectStepper" renderer-url="/_astro/client.DNdMcqFj.js" props="{&quot;projectId&quot;:[0,&quot;task-tracker&quot;]}" client="load" opts="{&quot;name&quot;:&quot;ProjectStepper&quot;,&quot;value&quot;:true}" await-children=""><div class="relative top-0 -mx-4 my-5 overflow-hidden rounded-none border border-x-0 bg-white transition-all sm:sticky sm:-mx-5 sm:rounded-none sm:border-x-0 sm:border-t-0 sm:bg-gray-50"><div class="px-4 py-2 text-sm transition-colors sm:flex sm:items-center bg-purple-600 text-white">Start building, submit solution and get feedback from the community.</div><div class="flex min-h-[60px] flex-col items-start justify-between gap-2 px-4 py-4 sm:flex-row sm:items-center sm:gap-3 sm:py-0"><button class="flex items-center gap-1.5 rounded-full bg-purple-600 py-1 pl-2 pr-2.5 text-sm text-white hover:bg-purple-700"><svg xmlns="http://www.w3.org/2000/svg" width="13" height="13" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-play" aria-hidden="true"><polygon points="6 3 20 12 6 21 6 3"></polygon></svg>
<p>Task tracker is a project used to track and manage your tasks. In this task, you will build a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on. This project will help you practice your programming skills, including working with the filesystem, handling user inputs, and building a simple CLI application.</p>
<h2 id="requirements">Requirements</h2>
<p>The application should run from the command line, accept user actions and inputs as arguments, and store the tasks in a JSON file. The user should be able to:</p>
<ul>
<li>Add, Update, and Delete tasks</li>
<li>Mark a task as in progress or done</li>
<li>List all tasks</li>
<li>List all tasks that are done</li>
<li>List all tasks that are not done</li>
<li>List all tasks that are in progress</li>
</ul>
<p>Here are some constraints to guide the implementation:</p>
<ul>
<li>You can use any programming language to build this project.</li>
<li>Use positional arguments in command line to accept user inputs.</li>
<li>Use a JSON file to store the tasks in the current directory.</li>
<li>The JSON file should be created if it does not exist.</li>
<li>Do not use any external libraries or frameworks to build this project.</li>
<li>Ensure to handle errors and edge cases gracefully.</li>
</ul>
<h3 id="example">Example</h3>
<p>The list of commands and their usage is given below:</p>
<pre class="astro-code dracula" style="background-color:#282A36;color:#F8F8F2; overflow-x: auto;" tabindex="0" data-language="bash"><code><span class="line"><span style="color:#6272A4"># Adding a new task</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> add</span><span style="color:#E9F284"> "</span><span style="color:#F1FA8C">Buy groceries</span><span style="color:#E9F284">"</span></span>
<span class="line"><span style="color:#6272A4"># Output: Task added successfully (ID: 1)</span></span>
<span class="line"></span>
<span class="line"><span style="color:#6272A4"># Updating and deleting tasks</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> update</span><span style="color:#BD93F9"> 1</span><span style="color:#E9F284"> "</span><span style="color:#F1FA8C">Buy groceries and cook dinner</span><span style="color:#E9F284">"</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> delete</span><span style="color:#BD93F9"> 1</span></span>
<span class="line"></span>
<span class="line"><span style="color:#6272A4"># Marking a task as in progress or done</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> mark-in-progress</span><span style="color:#BD93F9"> 1</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> mark-done</span><span style="color:#BD93F9"> 1</span></span>
<span class="line"></span>
<span class="line"><span style="color:#6272A4"># Listing all tasks</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> list</span></span>
<span class="line"></span>
<span class="line"><span style="color:#6272A4"># Listing tasks by status</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> list</span><span style="color:#F1FA8C"> done</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> list</span><span style="color:#F1FA8C"> todo</span></span>
<span class="line"><span style="color:#50FA7B">task-cli</span><span style="color:#F1FA8C"> list</span><span style="color:#F1FA8C"> in-progress</span></span></code></pre>
<h3 id="task-properties">Task Properties</h3>
<p>Each task should have the following properties:</p>
<ul>
<li><code>id</code>: A unique identifier for the task</li>
<li><code>description</code>: A short description of the task</li>
<li><code>status</code>: The status of the task (<code>todo</code>, <code>in-progress</code>, <code>done</code>)</li>
<li><code>createdAt</code>: The date and time when the task was created</li>
<li><code>updatedAt</code>: The date and time when the task was last updated</li>
</ul>
<p>Make sure to add these properties to the JSON file when adding a new task and update them when updating a task.</p>
<hr>
<h2 id="getting-started">Getting Started</h2>
<p>Here are a few steps to help you get started with the Task Tracker CLI project:</p>
<h3 id="set-up-your-development-environment">Set Up Your Development Environment</h3>
<ul>
<li>Choose a programming language you are comfortable with (e.g., Python, JavaScript, etc.).</li>
<li>Ensure you have a code editor or IDE installed (e.g., VSCode, PyCharm).</li>
</ul>
<h3 id="project-initialization">Project Initialization</h3>
<ul>
<li>Create a new project directory for your Task Tracker CLI.</li>
<li>Initialize a version control system (e.g., Git) to manage your project.</li>
</ul>
<h3 id="implementing-features">Implementing Features</h3>
<ul>
<li>Start by creating a basic CLI structure to handle user inputs.</li>
<li>Implement each feature one by one, ensuring to test thoroughly before moving to the next e.g. implement adding task functionality first, listing next, then updating, marking as in progress, etc.</li>
</ul>
<h3 id="testing-and-debugging">Testing and Debugging</h3>
<ul>
<li>Test each feature individually to ensure they work as expected. Look at the JSON file to verify that the tasks are being stored correctly.</li>
<li>Debug any issues that arise during development.</li>
</ul>
<h3 id="finalizing-the-project">Finalizing the Project</h3>
<ul>
<li>Ensure all features are implemented and tested.</li>
<li>Clean up your code and add comments where necessary.</li>
<li>Write a good readme file on how to use your Task Tracker CLI.</li>
</ul>
<hr>
<p>By the end of this project, you will have developed a practical tool that can help you or others manage tasks efficiently. This project lays a solid foundation for more advanced programming projects and real-world applications.</p>
<p>Happy coding!</p> </div> <div class="mt-5 flex flex-wrap items-center justify-center rounded-lg p-2.5 text-sm"> <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 98 96" xmlns:v="https://vecta.io/nano" class="mr-2 inline-block h-5 w-5"><path fill-rule="evenodd" d="M48.854 0C21.839 0 0 22 0 49.217c0 21.756 13.993 40.172 33.405 46.69 2.427.49 3.316-1.059 3.316-2.362l-.08-9.127c-13.59 2.934-16.42-5.867-16.42-5.867-2.184-5.704-5.42-7.17-5.42-7.17-4.448-3.015.324-3.015.324-3.015 4.934.326 7.523 5.052 7.523 5.052 4.367 7.496 11.404 5.378 14.235 4.074.404-3.178 1.699-5.378 3.074-6.6-10.839-1.141-22.243-5.378-22.243-24.283 0-5.378 1.94-9.778 5.014-13.2-.485-1.222-2.184-6.275.486-13.038 0 0 4.125-1.304 13.426 5.052a46.97 46.97 0 0 1 12.214-1.63c4.125 0 8.33.571 12.213 1.63 9.302-6.356 13.427-5.052 13.427-5.052 2.67 6.763.97 11.816.485 13.038 3.155 3.422 5.015 7.822 5.015 13.2 0 18.905-11.404 23.06-22.324 24.283 1.78 1.548 3.316 4.481 3.316 9.126l-.08 13.526c0 1.304.89 2.853 3.316 2.364 19.412-6.52 33.405-24.935 33.405-46.691C97.707 22 75.788 0 48.854 0z" fill="currentColor"></path></svg>
Found a mistake?
<a class="ml-1 underline underline-offset-2" href="https://github.com/kamranahmedse/developer-roadmap/tree/master/src/data/projects/task-tracker.md" target="_blank">
Help us improve.
</a> </div> </div>
