<h2><a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag" style="background-color: rgba(0, 10, 32, 0.05);"><div>Moengage</div><div class="companyTagsContainer--tagOccurence">1</div></div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>1897. Redistribute Characters to Make All Strings Equal</a></h2><h3>Easy</h3><hr><div><p>You are given an array of strings <code>words</code> (<strong>0-indexed</strong>).</p>

<p>In one operation, pick two <strong>distinct</strong> indices <code>i</code> and <code>j</code>, where <code>words[i]</code> is a non-empty string, and move <strong>any</strong> character from <code>words[i]</code> to <strong>any</strong> position in <code>words[j]</code>.</p>

<p>Return <code>true</code> <em>if you can make<strong> every</strong> string in </em><code>words</code><em> <strong>equal </strong>using <strong>any</strong> number of operations</em>,<em> and </em><code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["abc","aabc","bc"]
<strong>Output:</strong> true
<strong>Explanation:</strong> Move the first 'a' in <code>words[1] to the front of words[2],
to make </code><code>words[1]</code> = "abc" and words[2] = "abc".
All the strings are now equal to "abc", so return <code>true</code>.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["ab","a"]
<strong>Output:</strong> false
<strong>Explanation:</strong> It is impossible to make all the strings equal using the operation.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
</ul>
</div>