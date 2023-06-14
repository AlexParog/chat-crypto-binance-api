package com.application.views.chat;

import com.application.chat.handler.CommandProcessor;
import com.application.views.MainLayout;
import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.MessageManager;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import java.util.UUID;

@PageTitle("Крипто-чат")
@Route(value = "crypto-chat", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ChatView extends VerticalLayout {

    private final CommandProcessor commandProcessor;
    private final CollaborationMessageList messageList;
    private final CollaborationMessageInput messageInput;

    public ChatView(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;

        // Создание UserInfo для пользователя
        UserInfo user = new UserInfo(UUID.randomUUID().toString(), "Александр");
        UserInfo bot = new UserInfo(UUID.randomUUID().toString(), "КРИПТОнит");

        // Инициализация CollaborationMessageList с темой "chat" и UserInfo пользователя
        messageList = new CollaborationMessageList(user, "chat");
        messageList.setSizeFull();

        // Инициализация CollaborationMessageInput с CollaborationMessageList
        messageInput = new CollaborationMessageInput(messageList);
        messageInput.setWidthFull();

        // Добавление CollaborationMessageList и CollaborationMessageInput на ChatView
        add(messageList, messageInput);
        setSizeFull();

        // Создание MessageManager для прослушивания новых сообщений в чате
        MessageManager messageManager = new MessageManager(this, bot, "chat");
        messageManager.setMessageHandler(context -> {
            String message = context.getMessage().getText();
            // Обработка сообщения с использованием CommandProcessor
            String response = commandProcessor.handleMessage(message);
            // Добавление сообщений пользователя и бота в CollaborationMessageList
            add(new MessageInput(event -> {;
                messageManager.submit(response);
            }));
        });
    }
}






