@REM C:\Users\uswbdnu\IBM\rationalsdp\workspace\EAI_queues\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\quickServerStart.bat
@REM Generated: Thu Jul 30 16:14:09 PDT 2015

@setlocal
@echo off

@REM Bootstrap values ...
cd C:\Users\uswbdnu\IBM\Profile\LocalAppProfile\bin
call "C:\Users\uswbdnu\IBM\Profile\LocalAppProfile\bin\setupCmdLine.bat"
@REM For debugging the server process:
@REM set DEBUG=-Djava.compiler=NONE -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=7777

@REM Environment Settings
SET PATH=%WAS_PATH%


@REM Launch Command
"C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/java/bin/java"  %DEBUG% "-Declipse.security" "-Dosgi.install.area=C:\Program Files (x86)\IBM\SDP\runtimes\base_v7" "-Dosgi.configuration.area=C:\Users\uswbdnu\IBM\Profile\LocalAppProfile/configuration" "-Dosgi.framework.extensions=com.ibm.cds,com.ibm.ws.eclipse.adaptors" "-Xshareclasses:name=webspherev70,nonFatal" "-Xscmx50M" "-Dsun.reflect.inflationThreshold=250" "-Xbootclasspath/p:C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/java/jre/lib/ext/ibmorb.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/java/jre/lib/ext/ibmext.jar" "-classpath" "C:\Users\uswbdnu\IBM\Profile\LocalAppProfile/properties;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/properties;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib/startup.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib/bootstrap.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib/jsf-nls.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib/lmproxy.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib/urlprotocols.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/deploytool/itp/batchboot.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/deploytool/itp/batch2.jar;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/java/lib/tools.jar" "-Dibm.websphere.internalClassAccessMode=allow" "-Xms50m" "-Xmx256m" "-Dws.ext.dirs=C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/java/lib;C:\Users\uswbdnu\IBM\Profile\LocalAppProfile/classes;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/classes;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/installedChannels;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/lib/ext;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/web/help;C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/deploytool/itp/plugins/com.ibm.etools.ejbdeploy/runtime" "-Dderby.system.home=C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/derby" "-Dcom.ibm.itp.location=C:\Program Files (x86)\IBM\SDP\runtimes\base_v7/bin" "-Djava.util.logging.configureByServer=true" "-Duser.install.root=C:\Users\uswbdnu\IBM\Profile\LocalAppProfile" "-Djavax.management.builder.initial=com.ibm.ws.management.PlatformMBeanServerBuilder" "-Dwas.install.root=C:\Program Files (x86)\IBM\SDP\runtimes\base_v7" "-Dpython.cachedir=C:\Users\uswbdnu\IBM\Profile\LocalAppProfile/temp/cachedir" "-Djava.util.logging.manager=com.ibm.ws.bootstrap.WsLogManager" "-Dserver.root=C:\Users\uswbdnu\IBM\Profile\LocalAppProfile" "-Dcom.ibm.security.jgss.debug=off" "-Dcom.ibm.security.krb5.Krb5Debug=off" "-Dcom.ibm.ws.management.event.pull_notification_timeout=120000" "-Xquickstart" "-Djava.security.auth.login.config=C:\Users\uswbdnu\IBM\Profile\LocalAppProfile/properties/wsjaas.conf" "-Djava.security.policy=C:\Users\uswbdnu\IBM\Profile\LocalAppProfile/properties/server.policy" "com.ibm.wsspi.bootstrap.WSPreLauncher" "-nosplash" "-application" "com.ibm.ws.bootstrap.WSLauncher" "com.ibm.ws.runtime.WsServer" "C:\Users\uswbdnu\IBM\Profile\LocalAppProfile\config" "WL-DQ25NX1Node06Cell" "WL-DQ25NX1Node06" "server1"

@endlocal
