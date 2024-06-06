function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  karate.configure('headers', { Accept: 'application/json' });

  if (!env) {
    env = 'dev';
  }
  var config = {
    env: env,
    myVarName: 'someValue',
    ACCESS_TOKEN:"81866bb43c97ca33408f423fd277c91e4e5c4489",
    BASE_URL:"https://api.todoist.com/rest/v2",
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
  } else if (env == 'e2e') {
    // customize
  }
  return config;
}