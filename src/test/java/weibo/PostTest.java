package weibo;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weibo.dashboard.entity.Post;
import com.weibo.dashboard.service.PostService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/applicationContent.xml"})
public class PostTest {
	@Resource
	PostService postservice;
	@Test
	public void testFindList(){
		List<Post> list = postservice.findList();
		for (Post post : list) {
			System.out.println(post.getAuthorName()+post.getDisLikes());
			if(post.getCommentList()!=null){
				System.out.println(post.getCommentList().get(0));
			}
		}
	}
	@Test
	public void testAdd(){
		Post post = new Post();
		post.setAuthorName("小赵");
		post.setDate(new Date());
		post.setContent("Sunny day");
		int res = postservice.insert(post);
		System.out.println(res);
		
	}
}
