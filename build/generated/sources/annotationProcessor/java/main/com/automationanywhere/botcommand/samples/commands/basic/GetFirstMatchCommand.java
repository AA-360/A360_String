package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.bot.service.GlobalSessionContext;
import com.automationanywhere.botcommand.BotCommand;
import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.i18n.Messages;
import com.automationanywhere.commandsdk.i18n.MessagesFactory;
import java.lang.Boolean;
import java.lang.ClassCastException;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.String;
import java.lang.Throwable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GetFirstMatchCommand implements BotCommand {
  private static final Logger logger = LogManager.getLogger(GetFirstMatchCommand.class);

  private static final Messages MESSAGES_GENERIC = MessagesFactory.getMessages("com.automationanywhere.commandsdk.generic.messages");

  @Deprecated
  public Optional<Value> execute(Map<String, Value> parameters, Map<String, Object> sessionMap) {
    return execute(null, parameters, sessionMap);
  }

  public Optional<Value> execute(GlobalSessionContext globalSessionContext,
      Map<String, Value> parameters, Map<String, Object> sessionMap) {
    logger.traceEntry(() -> parameters != null ? parameters.entrySet().stream().filter(en -> !Arrays.asList( new String[] {}).contains(en.getKey()) && en.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).toString() : null, ()-> sessionMap != null ?sessionMap.toString() : null);
    GetFirstMatch command = new GetFirstMatch();
    HashMap<String, Object> convertedParameters = new HashMap<String, Object>();
    if(parameters.containsKey("value") && parameters.get("value") != null && parameters.get("value").get() != null) {
      convertedParameters.put("value", parameters.get("value").get());
      if(convertedParameters.get("value") !=null && !(convertedParameters.get("value") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","value", "String", parameters.get("value").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("value") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","value"));
    }

    if(parameters.containsKey("pattern") && parameters.get("pattern") != null && parameters.get("pattern").get() != null) {
      convertedParameters.put("pattern", parameters.get("pattern").get());
      if(convertedParameters.get("pattern") !=null && !(convertedParameters.get("pattern") instanceof String)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","pattern", "String", parameters.get("pattern").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("pattern") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","pattern"));
    }

    if(parameters.containsKey("caseInsensitive") && parameters.get("caseInsensitive") != null && parameters.get("caseInsensitive").get() != null) {
      convertedParameters.put("caseInsensitive", parameters.get("caseInsensitive").get());
      if(convertedParameters.get("caseInsensitive") !=null && !(convertedParameters.get("caseInsensitive") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","caseInsensitive", "Boolean", parameters.get("caseInsensitive").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("caseInsensitive") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","caseInsensitive"));
    }

    if(parameters.containsKey("multline") && parameters.get("multline") != null && parameters.get("multline").get() != null) {
      convertedParameters.put("multline", parameters.get("multline").get());
      if(convertedParameters.get("multline") !=null && !(convertedParameters.get("multline") instanceof Boolean)) {
        throw new BotCommandException(MESSAGES_GENERIC.getString("generic.UnexpectedTypeReceived","multline", "Boolean", parameters.get("multline").get().getClass().getSimpleName()));
      }
    }
    if(convertedParameters.get("multline") == null) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.validation.notEmpty","multline"));
    }

    try {
      Optional<Value> result =  Optional.ofNullable(command.action((String)convertedParameters.get("value"),(String)convertedParameters.get("pattern"),(Boolean)convertedParameters.get("caseInsensitive"),(Boolean)convertedParameters.get("multline")));
      return logger.traceExit(result);
    }
    catch (ClassCastException e) {
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.IllegalParameters","action"));
    }
    catch (BotCommandException e) {
      logger.fatal(e.getMessage(),e);
      throw e;
    }
    catch (Throwable e) {
      logger.fatal(e.getMessage(),e);
      throw new BotCommandException(MESSAGES_GENERIC.getString("generic.NotBotCommandException",e.getMessage()),e);
    }
  }
}
