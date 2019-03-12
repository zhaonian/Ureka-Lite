package io.keyu.urekalite.model

import io.keyu.urekalite.model.post.Post
import io.keyu.urekalite.model.post.Content
import io.keyu.urekalite.model.post.ChannelGroupGroup
import io.keyu.urekalite.model.post.ChannelGroup
import io.keyu.urekalite.model.post.ActionCount
import io.keyu.urekalite.model.post.Tag

class PostListDataSource {
    val postList: List<Post>? = listOf(
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, text texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        ),
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        ),
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, text texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        ),
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, text texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        ),
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, text texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        ),
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, text texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        ),
        Post(
            Content(
                3603,
                "UREKA ID 123",
                321,
                "channel title 1",
                122,
                "luan",
                "Zhaonian Luan",
                "avatar url",
                "title",
                "link",
                "text, text texttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttexttext",
                listOf("1", "2"),
                "engineer",
                ChannelGroupGroup(111, "ggn", "ggn_abbr", null),
                ChannelGroup(111, "gn", "gn_abbr")
            ),
            ActionCount(bookmark = 1L, like = 2L, comment = 2L, share = 0L),
            listOf(Tag(1, "tag1")),
            false,
            bookmarked = true,
            commented = false
        )
    )
}
