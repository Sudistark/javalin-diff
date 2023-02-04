package io.javalin.http.servlet;

import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.http.MethodNotAllowedResponse;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.util.MethodNotAllowedUtil;
import io.javalin.routing.HandlerEntry;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\t\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007R\027\020\b\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\t\020\007R\027\020\n\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\013\020\007R\027\020\f\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\r\020\007¨\006\016"}, d2 = {"Lio/javalin/http/servlet/DefaultTasks;", "", "()V", "AFTER", "Lio/javalin/http/servlet/TaskInitializer;", "Lio/javalin/http/servlet/JavalinServletContext;", "getAFTER", "()Lio/javalin/http/servlet/TaskInitializer;", "BEFORE", "getBEFORE", "ERROR", "getERROR", "HTTP", "getHTTP", "javalin"})
public final class DefaultTasks {
  @NotNull
  public static final DefaultTasks INSTANCE = new DefaultTasks();
  
  @NotNull
  private static final TaskInitializer<JavalinServletContext> BEFORE = DefaultTasks::BEFORE$lambda-2;
  
  @NotNull
  public final TaskInitializer<JavalinServletContext> getBEFORE() {
    return BEFORE;
  }
  
  private static final void BEFORE$lambda-2(Function2 submitTask, JavalinServlet servlet, JavalinServletContext ctx, String requestUri) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'submitTask'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'servlet'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc 'ctx'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: ldc 'requestUri'
    //   21: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual getMatcher : ()Lio/javalin/routing/PathMatcher;
    //   28: getstatic io/javalin/http/HandlerType.BEFORE : Lio/javalin/http/HandlerType;
    //   31: aload_3
    //   32: invokevirtual findEntries : (Lio/javalin/http/HandlerType;Ljava/lang/String;)Ljava/util/List;
    //   35: checkcast java/lang/Iterable
    //   38: astore #4
    //   40: iconst_0
    //   41: istore #5
    //   43: aload #4
    //   45: invokeinterface iterator : ()Ljava/util/Iterator;
    //   50: astore #6
    //   52: aload #6
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 112
    //   62: aload #6
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: astore #7
    //   71: aload #7
    //   73: checkcast io/javalin/routing/HandlerEntry
    //   76: astore #8
    //   78: iconst_0
    //   79: istore #9
    //   81: aload_0
    //   82: getstatic io/javalin/http/servlet/SubmitOrder.LAST : Lio/javalin/http/servlet/SubmitOrder;
    //   85: new io/javalin/http/servlet/Task
    //   88: dup
    //   89: iconst_1
    //   90: aload #8
    //   92: aload_2
    //   93: aload_3
    //   94: <illegal opcode> handle : (Lio/javalin/routing/HandlerEntry;Lio/javalin/http/servlet/JavalinServletContext;Ljava/lang/String;)Lio/javalin/http/servlet/TaskHandler;
    //   99: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;)V
    //   102: invokeinterface invoke : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: nop
    //   109: goto -> 52
    //   112: nop
    //   113: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #18	-> 24
    //   #79	-> 43
    //   #19	-> 81
    //   #20	-> 108
    //   #80	-> 112
    //   #21	-> 113
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   81	28	9	$i$a$-forEach-DefaultTasks$BEFORE$1$1	I
    //   78	31	8	entry	Lio/javalin/routing/HandlerEntry;
    //   71	38	7	element$iv	Ljava/lang/Object;
    //   43	70	5	$i$f$forEach	I
    //   40	73	4	$this$forEach$iv	Ljava/lang/Iterable;
    //   0	114	0	submitTask	Lkotlin/jvm/functions/Function2;
    //   0	114	1	servlet	Lio/javalin/http/servlet/JavalinServlet;
    //   0	114	2	ctx	Lio/javalin/http/servlet/JavalinServletContext;
    //   0	114	3	requestUri	Ljava/lang/String;
  }
  
  private static final Unit BEFORE$lambda-2$lambda-1$lambda-0(HandlerEntry $entry, JavalinServletContext $ctx, String $requestUri) {
    Intrinsics.checkNotNullParameter($entry, "$entry");
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    Intrinsics.checkNotNullParameter($requestUri, "$requestUri");
    $entry.handle($ctx, $requestUri);
    return Unit.INSTANCE;
  }
  
  @NotNull
  private static final TaskInitializer<JavalinServletContext> HTTP = DefaultTasks::HTTP$lambda-8;
  
  @NotNull
  public final TaskInitializer<JavalinServletContext> getHTTP() {
    return HTTP;
  }
  
  private static final void HTTP$lambda-8(Function2 submitTask, JavalinServlet servlet, JavalinServletContext ctx, String requestUri) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'submitTask'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'servlet'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc 'ctx'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: ldc 'requestUri'
    //   21: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual getMatcher : ()Lio/javalin/routing/PathMatcher;
    //   28: aload_2
    //   29: invokevirtual method : ()Lio/javalin/http/HandlerType;
    //   32: aload_3
    //   33: invokevirtual findEntries : (Lio/javalin/http/HandlerType;Ljava/lang/String;)Ljava/util/List;
    //   36: checkcast java/lang/Iterable
    //   39: astore #4
    //   41: iconst_0
    //   42: istore #5
    //   44: aload #4
    //   46: invokeinterface iterator : ()Ljava/util/Iterator;
    //   51: astore #6
    //   53: aload #6
    //   55: invokeinterface hasNext : ()Z
    //   60: ifeq -> 114
    //   63: aload #6
    //   65: invokeinterface next : ()Ljava/lang/Object;
    //   70: astore #7
    //   72: aload #7
    //   74: checkcast io/javalin/routing/HandlerEntry
    //   77: astore #8
    //   79: iconst_0
    //   80: istore #9
    //   82: aload_0
    //   83: getstatic io/javalin/http/servlet/SubmitOrder.LAST : Lio/javalin/http/servlet/SubmitOrder;
    //   86: new io/javalin/http/servlet/Task
    //   89: dup
    //   90: iconst_0
    //   91: aload_1
    //   92: aload_2
    //   93: aload #8
    //   95: aload_3
    //   96: aload_0
    //   97: <illegal opcode> handle : (Lio/javalin/http/servlet/JavalinServlet;Lio/javalin/http/servlet/JavalinServletContext;Lio/javalin/routing/HandlerEntry;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lio/javalin/http/servlet/TaskHandler;
    //   102: iconst_1
    //   103: aconst_null
    //   104: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   107: invokeinterface invoke : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: return
    //   114: nop
    //   115: aload_0
    //   116: getstatic io/javalin/http/servlet/SubmitOrder.LAST : Lio/javalin/http/servlet/SubmitOrder;
    //   119: new io/javalin/http/servlet/Task
    //   122: dup
    //   123: iconst_0
    //   124: aload_2
    //   125: aload_1
    //   126: aload_3
    //   127: <illegal opcode> handle : (Lio/javalin/http/servlet/JavalinServletContext;Lio/javalin/http/servlet/JavalinServlet;Ljava/lang/String;)Lio/javalin/http/servlet/TaskHandler;
    //   132: iconst_1
    //   133: aconst_null
    //   134: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   137: invokeinterface invoke : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #24	-> 24
    //   #81	-> 44
    //   #25	-> 82
    //   #26	-> 83
    //   #27	-> 86
    //   #25	-> 91
    //   #27	-> 102
    //   #25	-> 107
    //   #42	-> 113
    //   #82	-> 114
    //   #44	-> 115
    //   #61	-> 143
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   82	32	9	$i$a$-firstOrNull-DefaultTasks$HTTP$1$1	I
    //   79	35	8	entry	Lio/javalin/routing/HandlerEntry;
    //   72	42	7	element$iv	Ljava/lang/Object;
    //   44	71	5	$i$f$firstOrNull	I
    //   41	74	4	$this$firstOrNull$iv	Ljava/lang/Iterable;
    //   0	144	0	submitTask	Lkotlin/jvm/functions/Function2;
    //   0	144	1	servlet	Lio/javalin/http/servlet/JavalinServlet;
    //   0	144	2	ctx	Lio/javalin/http/servlet/JavalinServletContext;
    //   0	144	3	requestUri	Ljava/lang/String;
  }
  
  private static final Unit HTTP$lambda-8$lambda-6$lambda-5(JavalinServlet $servlet, JavalinServletContext $ctx, HandlerEntry $entry, String $requestUri, Function2 $submitTask) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '$servlet'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc '$ctx'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc '$entry'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: ldc '$requestUri'
    //   21: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   24: aload #4
    //   26: ldc '$submitTask'
    //   28: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   31: nop
    //   32: aload_0
    //   33: invokevirtual getCfg : ()Lio/javalin/config/JavalinConfig;
    //   36: getfield pvt : Lio/javalin/config/PrivateConfig;
    //   39: getfield accessManager : Lio/javalin/security/AccessManager;
    //   42: ifnull -> 96
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: invokevirtual update : (Lio/javalin/routing/HandlerEntry;Ljava/lang/String;)Lio/javalin/http/servlet/JavalinServletContext;
    //   51: pop
    //   52: aload_0
    //   53: invokevirtual getCfg : ()Lio/javalin/config/JavalinConfig;
    //   56: getfield pvt : Lio/javalin/config/PrivateConfig;
    //   59: getfield accessManager : Lio/javalin/security/AccessManager;
    //   62: dup
    //   63: ifnull -> 92
    //   66: aload #4
    //   68: aload_2
    //   69: aload_1
    //   70: aload_3
    //   71: <illegal opcode> handle : (Lkotlin/jvm/functions/Function2;Lio/javalin/routing/HandlerEntry;Lio/javalin/http/servlet/JavalinServletContext;Ljava/lang/String;)Lio/javalin/http/Handler;
    //   76: aload_1
    //   77: checkcast io/javalin/http/Context
    //   80: aload_2
    //   81: invokevirtual getRoles : ()Ljava/util/Set;
    //   84: invokeinterface manage : (Lio/javalin/http/Handler;Lio/javalin/http/Context;Ljava/util/Set;)V
    //   89: goto -> 129
    //   92: pop
    //   93: goto -> 129
    //   96: aload_2
    //   97: invokevirtual getRoles : ()Ljava/util/Set;
    //   100: checkcast java/util/Collection
    //   103: invokeinterface isEmpty : ()Z
    //   108: ifne -> 115
    //   111: iconst_1
    //   112: goto -> 116
    //   115: iconst_0
    //   116: ifeq -> 123
    //   119: invokestatic accessManagerNotConfiguredException : ()Ljava/lang/IllegalStateException;
    //   122: athrow
    //   123: aload_2
    //   124: aload_1
    //   125: aload_3
    //   126: invokevirtual handle : (Lio/javalin/http/servlet/JavalinServletContext;Ljava/lang/String;)V
    //   129: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
    //   132: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #28	-> 31
    //   #29	-> 32
    //   #30	-> 45
    //   #31	-> 52
    //   #33	-> 76
    //   #34	-> 80
    //   #31	-> 84
    //   #37	-> 96
    //   #37	-> 116
    //   #38	-> 123
    //   #40	-> 129
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	133	0	$servlet	Lio/javalin/http/servlet/JavalinServlet;
    //   0	133	1	$ctx	Lio/javalin/http/servlet/JavalinServletContext;
    //   0	133	2	$entry	Lio/javalin/routing/HandlerEntry;
    //   0	133	3	$requestUri	Ljava/lang/String;
    //   0	133	4	$submitTask	Lkotlin/jvm/functions/Function2;
  }
  
  private static final Unit HTTP$lambda-8$lambda-6$lambda-5$lambda-4$lambda-3(HandlerEntry $entry, JavalinServletContext $ctx, String $requestUri) {
    Intrinsics.checkNotNullParameter($entry, "$entry");
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    Intrinsics.checkNotNullParameter($requestUri, "$requestUri");
    $entry.handle($ctx, $requestUri);
    return Unit.INSTANCE;
  }
  
  private static final void HTTP$lambda-8$lambda-6$lambda-5$lambda-4(Function2 $submitTask, HandlerEntry $entry, JavalinServletContext $ctx, String $requestUri, Context it) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '$submitTask'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc '$entry'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc '$ctx'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: ldc '$requestUri'
    //   21: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   24: aload #4
    //   26: ldc 'it'
    //   28: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getstatic io/javalin/http/servlet/SubmitOrder.FIRST : Lio/javalin/http/servlet/SubmitOrder;
    //   35: new io/javalin/http/servlet/Task
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aload_2
    //   42: aload_3
    //   43: <illegal opcode> handle : (Lio/javalin/routing/HandlerEntry;Lio/javalin/http/servlet/JavalinServletContext;Ljava/lang/String;)Lio/javalin/http/servlet/TaskHandler;
    //   48: iconst_1
    //   49: aconst_null
    //   50: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   53: invokeinterface invoke : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #32	-> 31
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	60	0	$submitTask	Lkotlin/jvm/functions/Function2;
    //   0	60	1	$entry	Lio/javalin/routing/HandlerEntry;
    //   0	60	2	$ctx	Lio/javalin/http/servlet/JavalinServletContext;
    //   0	60	3	$requestUri	Ljava/lang/String;
    //   0	60	4	it	Lio/javalin/http/Context;
  }
  
  private static final Unit HTTP$lambda-8$lambda-7(JavalinServletContext $ctx, JavalinServlet $servlet, String $requestUri) {
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    Intrinsics.checkNotNullParameter($servlet, "$servlet");
    Intrinsics.checkNotNullParameter($requestUri, "$requestUri");
    if ($ctx.method() == HandlerType.HEAD && $servlet.getMatcher().hasEntries$javalin(HandlerType.GET, $requestUri))
      return Unit.INSTANCE; 
    if ($ctx.method() == HandlerType.HEAD || $ctx.method() == HandlerType.GET) {
      if ((($servlet.getCfg()).pvt.resourceHandler != null) ? ((($servlet.getCfg()).pvt.resourceHandler.handle($ctx.req(), (HttpServletResponse)new JavalinResourceResponseWrapper($ctx)) == true)) : false)
        return Unit.INSTANCE; 
      if (($servlet.getCfg()).pvt.singlePageHandler.handle($ctx))
        return Unit.INSTANCE; 
    } 
    if ($ctx.handlerType() == HandlerType.BEFORE)
      $ctx.setEndpointHandlerPath$javalin("No handler matched request path/method (404/405)"); 
    List<HandlerType> availableHandlerTypes = MethodNotAllowedUtil.INSTANCE.findAvailableHttpHandlerTypes($servlet.getMatcher(), $requestUri);
    if (($servlet.getCfg()).http.prefer405over404 && (!availableHandlerTypes.isEmpty()))
      throw new MethodNotAllowedResponse(null, MethodNotAllowedUtil.INSTANCE.getAvailableHandlerTypes($ctx, availableHandlerTypes), 1, null); 
    throw new NotFoundResponse(null, null, 3, null);
  }
  
  @NotNull
  private static final TaskInitializer<JavalinServletContext> ERROR = DefaultTasks::ERROR$lambda-10;
  
  @NotNull
  public final TaskInitializer<JavalinServletContext> getERROR() {
    return ERROR;
  }
  
  private static final Unit ERROR$lambda-10$lambda-9(JavalinServlet $servlet, JavalinServletContext $ctx) {
    Intrinsics.checkNotNullParameter($servlet, "$servlet");
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    $servlet.getErrorMapper().handle($ctx.statusCode(), $ctx);
    return Unit.INSTANCE;
  }
  
  private static final void ERROR$lambda-10(Function2 submitTask, JavalinServlet servlet, JavalinServletContext ctx, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'submitTask'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'servlet'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc 'ctx'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: ldc_w '<anonymous parameter 3>'
    //   22: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getstatic io/javalin/http/servlet/SubmitOrder.LAST : Lio/javalin/http/servlet/SubmitOrder;
    //   29: new io/javalin/http/servlet/Task
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aload_2
    //   36: <illegal opcode> handle : (Lio/javalin/http/servlet/JavalinServlet;Lio/javalin/http/servlet/JavalinServletContext;)Lio/javalin/http/servlet/TaskHandler;
    //   41: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;)V
    //   44: invokeinterface invoke : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #64	-> 25
    //   #65	-> 50
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	51	0	submitTask	Lkotlin/jvm/functions/Function2;
    //   0	51	1	servlet	Lio/javalin/http/servlet/JavalinServlet;
    //   0	51	2	ctx	Lio/javalin/http/servlet/JavalinServletContext;
  }
  
  @NotNull
  private static final TaskInitializer<JavalinServletContext> AFTER = DefaultTasks::AFTER$lambda-13;
  
  @NotNull
  public final TaskInitializer<JavalinServletContext> getAFTER() {
    return AFTER;
  }
  
  private static final void AFTER$lambda-13(Function2 submitTask, JavalinServlet servlet, JavalinServletContext ctx, String requestUri) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'submitTask'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'servlet'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc 'ctx'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: ldc 'requestUri'
    //   21: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual getMatcher : ()Lio/javalin/routing/PathMatcher;
    //   28: getstatic io/javalin/http/HandlerType.AFTER : Lio/javalin/http/HandlerType;
    //   31: aload_3
    //   32: invokevirtual findEntries : (Lio/javalin/http/HandlerType;Ljava/lang/String;)Ljava/util/List;
    //   35: checkcast java/lang/Iterable
    //   38: astore #4
    //   40: iconst_0
    //   41: istore #5
    //   43: aload #4
    //   45: invokeinterface iterator : ()Ljava/util/Iterator;
    //   50: astore #6
    //   52: aload #6
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 112
    //   62: aload #6
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: astore #7
    //   71: aload #7
    //   73: checkcast io/javalin/routing/HandlerEntry
    //   76: astore #8
    //   78: iconst_0
    //   79: istore #9
    //   81: aload_0
    //   82: getstatic io/javalin/http/servlet/SubmitOrder.LAST : Lio/javalin/http/servlet/SubmitOrder;
    //   85: new io/javalin/http/servlet/Task
    //   88: dup
    //   89: iconst_0
    //   90: aload #8
    //   92: aload_2
    //   93: aload_3
    //   94: <illegal opcode> handle : (Lio/javalin/routing/HandlerEntry;Lio/javalin/http/servlet/JavalinServletContext;Ljava/lang/String;)Lio/javalin/http/servlet/TaskHandler;
    //   99: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;)V
    //   102: invokeinterface invoke : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: nop
    //   109: goto -> 52
    //   112: nop
    //   113: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #68	-> 24
    //   #83	-> 43
    //   #69	-> 81
    //   #70	-> 108
    //   #84	-> 112
    //   #71	-> 113
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   81	28	9	$i$a$-forEach-DefaultTasks$AFTER$1$1	I
    //   78	31	8	entry	Lio/javalin/routing/HandlerEntry;
    //   71	38	7	element$iv	Ljava/lang/Object;
    //   43	70	5	$i$f$forEach	I
    //   40	73	4	$this$forEach$iv	Ljava/lang/Iterable;
    //   0	114	0	submitTask	Lkotlin/jvm/functions/Function2;
    //   0	114	1	servlet	Lio/javalin/http/servlet/JavalinServlet;
    //   0	114	2	ctx	Lio/javalin/http/servlet/JavalinServletContext;
    //   0	114	3	requestUri	Ljava/lang/String;
  }
  
  private static final Unit AFTER$lambda-13$lambda-12$lambda-11(HandlerEntry $entry, JavalinServletContext $ctx, String $requestUri) {
    Intrinsics.checkNotNullParameter($entry, "$entry");
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    Intrinsics.checkNotNullParameter($requestUri, "$requestUri");
    $entry.handle($ctx, $requestUri);
    return Unit.INSTANCE;
  }
}
